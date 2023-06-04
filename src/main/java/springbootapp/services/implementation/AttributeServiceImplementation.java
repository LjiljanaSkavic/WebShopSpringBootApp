package springbootapp.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springbootapp.base.CrudJpaService;
import springbootapp.models.Attribute;
import springbootapp.models.AttributeValueKeys;
import springbootapp.models.entities.AttributeEntity;
import springbootapp.repositories.AttributeEntityRepository;
import springbootapp.services.AttributeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttributeServiceImplementation extends CrudJpaService<AttributeEntity, Integer> implements AttributeService {

    AttributeEntityRepository repository;
    ModelMapper modelMapper;

    public AttributeServiceImplementation(AttributeEntityRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper, AttributeEntity.class);
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Attribute> getAllByCategoryId(Integer categoryId) {
        return this.repository.getAllByCategoryId(categoryId).stream().map(e -> modelMapper.map(e, Attribute.class)).collect(Collectors.toList());
    }


    @Override
    public List<AttributeValueKeys> getAllByProductId(Integer productId) {
        return this.repository.getAllByProductId(productId).stream().map(e -> modelMapper.map(e, AttributeValueKeys.class)).collect(Collectors.toList());
    }
}
