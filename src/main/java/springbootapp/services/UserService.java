package springbootapp.services;

import springbootapp.base.CrudService;
import springbootapp.models.User;

public interface UserService extends CrudService<Integer> {
    User getByUsernameAndPassword(String username, String password);
}
