package space.ffisherr.openborders.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.ffisherr.openborders.model.UserDTO;

@RestController
@RequestMapping("/user/")
public class UserController {

    @GetMapping("/me/")
    public UserDTO getUsername() {
        final UserDTO user = new UserDTO(); // FIXME
        user.setUserName("Иван");
        return user;
    }

}
