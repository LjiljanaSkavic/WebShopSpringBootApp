package springbootapp.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springbootapp.exceptions.NotFoundException;
import springbootapp.models.SingleUser;
import springbootapp.models.User;
import springbootapp.repositories.UserEntityRepository;
import springbootapp.services.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {
    private ModelMapper modelMapper;
    private final UserEntityRepository repository;

    public UserServiceImplementation(UserEntityRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<User> findAll() {
        return repository.findAll().stream().map(userEntity -> modelMapper.map(userEntity, User.class)).collect(Collectors.toList());
    }

    @Override
    public SingleUser findById(Integer id) throws NotFoundException {
        return modelMapper.map(repository.findById(id).orElseThrow(NotFoundException::new), SingleUser.class);
    }
}
