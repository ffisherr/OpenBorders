package space.ffisherr.openborders.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.ffisherr.openborders.model.MessageDTO;
import space.ffisherr.openborders.service.MessagesService;

@Slf4j
@RestController
@RequestMapping("messages")
@RequiredArgsConstructor
public class MessagesController {

    private final MessagesService service;

    @GetMapping
    public Slice<MessageDTO> readAllByUser(Pageable pageable) {
        final Long userId = 1L; // TODO temp fix
        log.info("Reading all messages by user with id {}", userId);
        return service.readAllMessagesByUser(userId, pageable);
    }

}
