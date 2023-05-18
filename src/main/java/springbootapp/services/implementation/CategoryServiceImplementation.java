package springbootapp.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springbootapp.base.CrudJpaService;
import springbootapp.models.entities.CategoryEntity;
import springbootapp.repositories.CategoryEntityRepository;
import springbootapp.services.CategoryService;

@Service
public class CategoryServiceImplementation extends CrudJpaService<CategoryEntity, Integer> implements CategoryService {

    public CategoryServiceImplementation(CategoryEntityRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper, CategoryEntity.class);
    }
}
