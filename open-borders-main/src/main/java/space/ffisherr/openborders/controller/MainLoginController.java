package space.ffisherr.openborders.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainLoginController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "mainpage");
        return "home";
    }

}