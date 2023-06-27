package springbootapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootapp.base.CrudController;
import springbootapp.models.User;
import springbootapp.models.UserRequest;
import springbootapp.services.implementation.UserServiceImplementation;

@RestController
@RequestMapping("/users")
public class UserController extends CrudController<Integer, UserRequest, User> {

    public UserController(UserServiceImplementation userService) {
        super(User.class, userService);
    }
}
