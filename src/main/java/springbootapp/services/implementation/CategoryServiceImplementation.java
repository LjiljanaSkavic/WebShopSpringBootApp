package springbootapp.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springbootapp.exceptions.NotFoundException;
import springbootapp.models.Category;
import springbootapp.repositories.CategoryEntityRepository;
import springbootapp.services.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImplementation implements CategoryService {

    private ModelMapper modelMapper;

    private final CategoryEntityRepository repository;

    public CategoryServiceImplementation(CategoryEntityRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Category> findAll() {
        return repository.findAll().stream().map(productEntity -> modelMapper.map(productEntity, Category.class)).collect(Collectors.toList());
    }

    @Override
    public Category findById(Integer id) throws NotFoundException {
        return modelMapper.map(repository.findById(id).orElseThrow(NotFoundException::new), Category.class);
    }
}
