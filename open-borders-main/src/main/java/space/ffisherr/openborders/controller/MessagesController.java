package space.ffisherr.openborders.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.ffisherr.openborders.model.MessageDTO;
import space.ffisherr.openborders.service.MessagesService;

@RestController
@RequestMapping("messages")
@RequiredArgsConstructor
public class MessagesController {

    private final MessagesService service;

    @GetMapping
    public Slice<MessageDTO> readAllByUser() {
        final Long userId = 1L; // TODO temp fix
        return service.readAllMessagesByUser(userId);
    }

}
