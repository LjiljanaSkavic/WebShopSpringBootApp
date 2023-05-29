package springbootapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springbootapp.exceptions.NotFoundException;
import springbootapp.models.User;
import springbootapp.services.SharedService;
import springbootapp.services.implementation.UserServiceImplementation;

@RestController
@RequestMapping("/register")
public class RegisterController {

    UserServiceImplementation userService;
    SharedService sharedService;

    public RegisterController(UserServiceImplementation userService, SharedService sharedService) {
        this.userService = userService;
        this.sharedService = sharedService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User insert(@RequestBody User user) throws NotFoundException {
        user.setActivationPin(this.sharedService.createActivationPin());
        return this.userService.insert(user, User.class);
    }
}
