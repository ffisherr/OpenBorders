package space.ffisherr.openborders.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import space.ffisherr.openborders.model.MessageDTO;
import space.ffisherr.openborders.converter.MessagesConverter;
import space.ffisherr.openborders.repository.MessagesRepository;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessagesService {

    private final MessagesRepository repository;
    private final MessagesConverter converter;

    @Override
    public void userSendMessage(Long userId, String message) {

    }

    @Override
    public Slice<MessageDTO> readAllMessagesByUser(Long userId, Pageable pageable) {
        return repository.findByUserId(userId, pageable).map(converter::convertFromEntity);
    }
}
