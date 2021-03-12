package space.ffisherr.openborders.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import space.ffisherr.openborders.entity.Messages;
import space.ffisherr.openborders.model.MessageDTO;
import space.ffisherr.openborders.converter.MessagesConverter;
import space.ffisherr.openborders.repository.MessagesRepository;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessagesService {

    private final MessagesRepository repository;
    private final MessagesConverter converter;

    @Override
    public void userSendMessage(Long userId, MessageDTO model) {
        Messages message = converter.convertToEntity(model);
        message.setUserId(userId);
        message.setSentAt(new Timestamp(System.currentTimeMillis()));
        message = repository.save(message);
        createBotAnswer(message);
    }

    @Override
    public Slice<MessageDTO> readAllMessagesByUser(Long userId, Pageable pageable) {
        return repository.findByUserId(userId, PageRequest.of(0, Integer.MAX_VALUE-1, Sort.by("sentAt")))
                .map(converter::convertFromEntity);
    }

    private void createBotAnswer(Messages userMessage) {
        final Messages botMessage = new Messages();
        botMessage.setIsFrom(false);
        botMessage.setUserId(userMessage.getUserId());
        botMessage.setMessage("Когда-нибудь я тебя пойму");
        botMessage.setSentAt(new Timestamp(System.currentTimeMillis()));
        repository.save(botMessage);
    }
}
