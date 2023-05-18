package springbootapp.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springbootapp.base.CrudJpaService;
import springbootapp.models.entities.UserEntity;
import springbootapp.repositories.UserEntityRepository;
import springbootapp.services.UserService;

@Service
public class UserServiceImplementation extends CrudJpaService<UserEntity, Integer> implements UserService {
    public UserServiceImplementation(UserEntityRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper, UserEntity.class);
    }

//    @Override
//    public <T> List<T> findAll(Class<T> resultDtoClass) {
//        System.out.println("RADI - pozvala se preklopljena metoda");
//        TypeMap<UserEntity, User> propertyMapping = modelMapper.createTypeMap(UserEntity.class, User.class);
//        propertyMapping
//                .addMappings(mapper -> mapper.skip(User::setCountry))
//                .addMappings(mapper -> mapper.skip(User::setLocation));
//        return repository.findAll().stream().map(e -> modelMapper.map(e, resultDtoClass)).collect(Collectors.toList());
//    }
}
