package springbootapp.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import springbootapp.base.CrudJpaService;
import springbootapp.models.entities.UserEntity;
import springbootapp.services.UserService;

@Service
public class UserServiceImplementation extends CrudJpaService<UserEntity, Integer> implements UserService {
    public UserServiceImplementation(JpaRepository<UserEntity, Integer> repository, ModelMapper modelMapper) {
        super(repository, modelMapper, UserEntity.class);
    }
}
