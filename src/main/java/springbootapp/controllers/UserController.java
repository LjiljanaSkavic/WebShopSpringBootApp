package springbootapp.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootapp.base.CrudController;
import springbootapp.models.User;
import springbootapp.models.UserRequest;
import springbootapp.services.implementation.UserServiceImplementation;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/users")
public class UserController extends CrudController<Integer, UserRequest, User> {

    public UserController(UserServiceImplementation userService) {
        super(User.class, userService);
    }
}
