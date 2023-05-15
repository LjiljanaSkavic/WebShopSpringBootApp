package springbootapp.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springbootapp.exceptions.NotFoundException;
import springbootapp.models.Attribute;
import springbootapp.repositories.AttributeEntityRepository;
import springbootapp.services.AttributeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttributeServiceImplementation implements AttributeService {

    private ModelMapper modelMapper;

    private final AttributeEntityRepository repository;

    public AttributeServiceImplementation(AttributeEntityRepository repository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    @Override
    public List<Attribute> findAll() {
        return repository.findAll().stream().map(productEntity -> modelMapper.map(productEntity, Attribute.class)).collect(Collectors.toList());
    }

    @Override
    public Attribute findById(Integer id) throws NotFoundException {
        return modelMapper.map(repository.findById(id).orElseThrow(NotFoundException::new), Attribute.class);
    }

//    @Override
//    public List<Attribute> getAllAttributesByCategoryId(Integer id) {
//        return repository.getAllByCategory_Id(id).stream().map(attributeEntity -> modelMapper.map(attributeEntity, Attribute.class)).collect(Collectors.toList());
//    }
}
