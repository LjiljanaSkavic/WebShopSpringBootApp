package springbootapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springbootapp.exceptions.NotFoundException;
import springbootapp.models.LoginUser;
import springbootapp.models.User;
import springbootapp.services.implementation.UserServiceImplementation;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/login")
public class LoginController {
    UserServiceImplementation userService;

    public LoginController(UserServiceImplementation userService) {
        this.userService = userService;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public User update(@RequestBody LoginUser loginCredentials) throws NotFoundException {
        System.out.println(loginCredentials);
        return this.userService.getByUsernameAndPassword(loginCredentials.getUsername(), loginCredentials.getPassword());
    }
}