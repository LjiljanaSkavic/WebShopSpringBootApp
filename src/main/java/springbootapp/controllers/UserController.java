package springbootapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import springbootapp.base.CrudController;
import springbootapp.exceptions.NotFoundException;
import springbootapp.models.User;
import springbootapp.models.UserRequest;
import springbootapp.services.implementation.UserServiceImplementation;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/users")
public class UserController extends CrudController<Integer, UserRequest, User> {

    UserServiceImplementation userService;

    public UserController(UserServiceImplementation userService) {
        super(User.class, userService);
        this.userService = userService;
    }

    @PutMapping("/sign-out/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void signOut(@PathVariable Integer id) throws NotFoundException {
        this.userService.logoutUser(id);
    }
}
