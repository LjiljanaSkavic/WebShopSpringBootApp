package springbootapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootapp.exceptions.NotFoundException;
import springbootapp.models.SingleUser;
import springbootapp.models.User;
import springbootapp.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public SingleUser findById(@PathVariable Integer id) throws NotFoundException {
        return userService.findById(id);
    }

}
