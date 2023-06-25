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
        User user = this.userService.getByUsernameAndPassword(loginCredentials.getUsername(), loginCredentials.getPassword());
        System.out.println(user);
        if (!user.getIsActivated()) {
            this.userService.activateUser(user.getId());
            System.out.println("activate user");
        } else if (!user.getIsLoggedIn()) {
            this.userService.loginUser(user.getId());
            System.out.println("login user");
        }
        return this.userService.getByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public void activate(@PathVariable Integer id) throws NotFoundException {
//        this.userService.loginUser(id);
//    }
}