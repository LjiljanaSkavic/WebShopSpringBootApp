package springbootapp.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import springbootapp.base.CrudJpaService;
import springbootapp.models.entities.AttributeEntity;
import springbootapp.services.AttributeService;

@Service
public class AttributeServiceImplementation extends CrudJpaService<AttributeEntity, Integer> implements AttributeService {

    public AttributeServiceImplementation(JpaRepository<AttributeEntity, Integer> repository, ModelMapper modelMapper) {
        super(repository, modelMapper, AttributeEntity.class);
    }
}
