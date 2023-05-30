package springbootapp.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springbootapp.base.CrudJpaService;
import springbootapp.exceptions.NotFoundException;
import springbootapp.models.User;
import springbootapp.models.entities.UserEntity;
import springbootapp.repositories.UserEntityRepository;
import springbootapp.services.UserService;

@Service
public class UserServiceImplementation extends CrudJpaService<UserEntity, Integer> implements UserService {

    UserEntityRepository repository;
    ModelMapper modelMapper;

    public UserServiceImplementation(UserEntityRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper, UserEntity.class);
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public User getByUsernameAndPassword(String username, String password) throws NotFoundException {
        return this.modelMapper.map(repository.getUserEntityByUsernameAndPassword(username, password).orElseThrow(NotFoundException::new), User.class);
    }

    @Override
    public void activateUser(Integer id) throws NotFoundException {
        repository.activateUser(id);
    }

    @Override
    public void loginUser(Integer id) {
        repository.loginUser(id);
    }

}
