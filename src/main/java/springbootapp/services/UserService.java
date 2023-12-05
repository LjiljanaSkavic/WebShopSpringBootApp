package springbootapp.services;

import springbootapp.base.CrudService;
import springbootapp.exceptions.NotFoundException;
import springbootapp.models.User;

public interface UserService extends CrudService<Integer> {
    User getByUsernameAndPassword(String username, String password);

    User getById(Integer id) throws NotFoundException;

    void activateUser(Integer id);

    void loginUser(Integer id);

    void logoutUser(Integer id);
}
