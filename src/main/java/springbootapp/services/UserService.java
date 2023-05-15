package springbootapp.services;

import springbootapp.exceptions.NotFoundException;
import springbootapp.models.SingleUser;
import springbootapp.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    SingleUser findById(Integer id) throws NotFoundException;
}
