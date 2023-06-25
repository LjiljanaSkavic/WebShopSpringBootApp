package springbootapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springbootapp.exceptions.NotFoundException;
import springbootapp.models.Email;
import springbootapp.models.User;
import springbootapp.models.UserRequest;
import springbootapp.services.SharedService;
import springbootapp.services.implementation.EmailServiceImplementation;
import springbootapp.services.implementation.UserServiceImplementation;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/register")
public class RegisterController {

    UserServiceImplementation userService;
    SharedService sharedService;
    EmailServiceImplementation emailServiceImplementation;

    public RegisterController(UserServiceImplementation userService, SharedService sharedService, EmailServiceImplementation emailServiceImplementation) {
        this.userService = userService;
        this.sharedService = sharedService;
        this.emailServiceImplementation = emailServiceImplementation;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User insert(@RequestBody UserRequest user) throws NotFoundException {
        System.out.println(user);
        user.setActivationPin(this.sharedService.createActivationPin());
        Email email = new Email(user.getEmail(), user.getActivationPin());
        this.emailServiceImplementation.sendMail(email);
        return this.userService.insert(user, User.class);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void activate(@PathVariable Integer id) throws NotFoundException {
        this.userService.activateUser(id);
    }
}
