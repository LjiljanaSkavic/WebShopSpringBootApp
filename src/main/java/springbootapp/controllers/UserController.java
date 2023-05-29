package springbootapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootapp.base.CrudController;
import springbootapp.models.User;
import springbootapp.models.UserRequest;
import springbootapp.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController extends CrudController<Integer, UserRequest, User> {
    public UserController(UserService userService) {
        super(User.class, userService);
    }
}
