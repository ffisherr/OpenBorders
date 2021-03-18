package space.ffisherr.openborders.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import space.ffisherr.openborders.entity.Countries;
import space.ffisherr.openborders.entity.Messages;
import space.ffisherr.openborders.model.MessageDTO;
import space.ffisherr.openborders.converter.MessagesConverter;
import space.ffisherr.openborders.repository.MessagesRepository;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessagesService {

    private static final String ALL_COMMANDS_CODE = "1";
    private static final String GET_OPENED_COUNTRY_CODE = "2";
    private static final String ADD_WANTED_COUNTRY_CODE = "3";
    private static final List<String> ALL_COMMANDS_LIST = Arrays.asList(
            ALL_COMMANDS_CODE + " - получение списка комманд",
            GET_OPENED_COUNTRY_CODE + " - получить оповещения",
            ADD_WANTED_COUNTRY_CODE + " - добавить страну для посещения"
    );
    private final MessagesRepository repository;
    private final MessagesConverter converter;
    private final CountryService countryService;

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
        final String resultMessageText = getResultMessage(userMessage);
        final Messages botMessage = new Messages();
        botMessage.setIsFrom(false);
        botMessage.setUserId(userMessage.getUserId());
        botMessage.setMessage(resultMessageText);
        botMessage.setSentAt(new Timestamp(System.currentTimeMillis()));
        repository.save(botMessage);
    }

    private String getResultMessage(Messages message) {
        String result = "Команда не распознана. Для получения списка команд введите " + ALL_COMMANDS_CODE;
        final String text = message.getMessage();
        if (text == null || text.isEmpty()) {
            return result;
        }
        switch (text) {
            case ALL_COMMANDS_CODE:
                result = ALL_COMMANDS_LIST.toString();
                break;
            case GET_OPENED_COUNTRY_CODE:
                result = countryService.getOpenedCountries(message.getUserId()).toString();
                break;
            case ADD_WANTED_COUNTRY_CODE:
                result = "Введите название страны которую вы хотели бы посетить, " +
                        "и мы обязательно сообщим вам как только она откроется!";
                break;
            default:
                final Optional<Messages> optionalUserMessage = repository.getPreviousUserMessage(message.getUserId());
                if (optionalUserMessage.isPresent()) {
                    final String previousUserMessage = optionalUserMessage.get().getMessage();
                    if (ADD_WANTED_COUNTRY_CODE.equals(previousUserMessage)) {
                        final Countries country = countryService.getCountry(text);
                        result = "Страна не найдена, повторить шаги заново! (Название страны вводится с большой буквы)";
                        if (country != null) {
                            countryService.addCountryForUser(country, message.getUserId());
                            result = "Страна успешно найдена и добавлена в список!";
                        }
                    }
                }
                break;
        }
        return result;
    }
}
