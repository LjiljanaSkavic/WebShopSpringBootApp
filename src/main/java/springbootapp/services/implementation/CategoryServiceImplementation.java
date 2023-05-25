package springbootapp.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springbootapp.base.CrudJpaService;
import springbootapp.models.Category;
import springbootapp.models.entities.CategoryEntity;
import springbootapp.repositories.CategoryEntityRepository;
import springbootapp.services.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImplementation extends CrudJpaService<CategoryEntity, Integer> implements CategoryService {

    CategoryEntityRepository repository;
    ModelMapper modelMapper;

    public CategoryServiceImplementation(CategoryEntityRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper, CategoryEntity.class);
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Category> getAllByParentCategoryId(Integer parentCategoryId) {
//        List<Category> parentCategories = this.repository.getAllParentCategories().stream().map(e -> modelMapper.map(e, Category.class)).collect(Collectors.toList());
//        ArrayList<CategoryDetails> list = new ArrayList<CategoryDetails>();
//        for (Category parentCategory : parentCategories) {
//            list.add(new CategoryDetails(parentCategory.getId(), parentCategory.getName(), (CategoryEntity[]) this.repository.getAllByParentCategoryId(parentCategory.getId()).stream().toArray()));
//        }
//        System.out.println(parentCategories);
//        //TODO: Find way how to map to CategoryDetails
//        System.out.println(this.repository.getAllByParentCategoryId(parent_category_id));
        return this.repository.getAllByParentCategoryId(parentCategoryId).stream().map(e -> modelMapper.map(e, Category.class)).collect(Collectors.toList());
    }
}
