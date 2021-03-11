package space.ffisherr.openborders.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat/")
public class MainChatController {

    @GetMapping
    public String greeting () {
        return "Hello";
    }

    @PostMapping
    public String posting (){
        return "Post";
    }

}
