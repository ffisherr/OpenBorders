package space.ffisherr.openborders.service;

import org.springframework.data.domain.Slice;
import space.ffisherr.openborders.model.MessageDTO;

public interface MessagesService {

   void userSendMessage(Long userId, String message);

   Slice<MessageDTO> readAllMessagesByUser(Long userId);

}