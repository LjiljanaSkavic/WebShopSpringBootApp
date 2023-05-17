package springbootapp.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import springbootapp.base.CrudJpaService;
import springbootapp.models.entities.CategoryEntity;
import springbootapp.services.CategoryService;

@Service
public class CategoryServiceImplementation extends CrudJpaService<CategoryEntity, Integer> implements CategoryService {

    public CategoryServiceImplementation(JpaRepository<CategoryEntity, Integer> repository, ModelMapper modelMapper) {
        super(repository, modelMapper, CategoryEntity.class);
    }
}
