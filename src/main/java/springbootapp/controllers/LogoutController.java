package springbootapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springbootapp.exceptions.NotFoundException;
import springbootapp.services.implementation.UserServiceImplementation;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/logout")
public class LogoutController {
    UserServiceImplementation userService;

    public LogoutController(UserServiceImplementation userService) {
        this.userService = userService;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void signOut(@PathVariable Integer id) throws NotFoundException {
        this.userService.logoutUser(id);
    }
}
