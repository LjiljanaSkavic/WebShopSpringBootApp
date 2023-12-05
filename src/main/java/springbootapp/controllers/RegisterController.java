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
    String emailReceiver = "skavic.ljiljana@gmail.com";

    public RegisterController(UserServiceImplementation userService, SharedService sharedService, EmailServiceImplementation emailServiceImplementation) {
        this.userService = userService;
        this.sharedService = sharedService;
        this.emailServiceImplementation = emailServiceImplementation;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User insert(@RequestBody UserRequest user) throws NotFoundException {
        user.setActivationPin(this.sharedService.createActivationPin());
        Email email = new Email(emailReceiver, "Web shop app", "Your activation pin for Web shop app is: " + user.getActivationPin());
        this.emailServiceImplementation.sendEmail(email);
        return this.userService.insert(user, User.class);
    }

    @PutMapping("/activate/{id}")
    @ResponseStatus(HttpStatus.OK)
    public int sendEmail(@PathVariable Integer id) throws NotFoundException {
        int activationPin = this.sharedService.createActivationPin();
        Email email = new Email(emailReceiver, "Web shop app", "Your activation pin for Web shop app is: " + activationPin);
        this.emailServiceImplementation.sendEmail(email);
        return activationPin;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void activate(@PathVariable Integer id) throws NotFoundException {
        this.userService.activateUser(id);
    }
}
