package space.ffisherr.openborders.converter;

import org.springframework.stereotype.Component;
import space.ffisherr.openborders.model.MessageDTO;
import space.ffisherr.openborders.entity.Messages;

@Component
public class MessagesConverter implements Converter<MessageDTO, Messages> {


    @Override
    public MessageDTO convertFromEntity(Messages entity) {
        final MessageDTO model = new MessageDTO();
        model.setId(entity.getId());
        model.setUserId(entity.getUserId());
        model.setIsFromUser(entity.getIsFrom());
        model.setMessage(entity.getMessage());
        model.setTimestamp(entity.getSentAt());
        return model;
    }

    @Override
    public Messages convertToEntity(MessageDTO model) {
        final Messages entity = new Messages();
        entity.setMessage(model.getMessage());
        entity.setIsFrom(model.getIsFromUser());
        entity.setUserId(model.getUserId());
        return entity;
    }
}
