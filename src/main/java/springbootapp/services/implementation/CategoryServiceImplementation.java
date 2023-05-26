package springbootapp.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springbootapp.base.CrudJpaService;
import springbootapp.models.Category;
import springbootapp.models.CategoryWithChildren;
import springbootapp.models.CategoryWithParentId;
import springbootapp.models.entities.CategoryEntity;
import springbootapp.repositories.CategoryEntityRepository;
import springbootapp.services.CategoryService;

import java.util.ArrayList;
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
        return this.repository.getAllByParentCategoryId(parentCategoryId).stream().map(e -> modelMapper.map(e, Category.class)).collect(Collectors.toList());
    }

    @Override
    public List<CategoryWithChildren> getAllCustomMethod() {
        List<CategoryWithParentId> allCategories = this.repository.getAllCustomMethod().stream().map(e -> modelMapper.map(e, CategoryWithParentId.class)).collect(Collectors.toList());
        List<CategoryWithParentId> rootCategories = allCategories.stream().filter(categoryWithParentId -> categoryWithParentId.getParentCategoryId() == null).collect(Collectors.toList());

        List<CategoryWithChildren> result = new ArrayList<CategoryWithChildren>();
        for (int i = 0; i < rootCategories.size(); i++) {
            result.add(fillChildren(rootCategories.get(i), allCategories));
        }
        return result;
    }

    private CategoryWithChildren fillChildren(CategoryWithParentId parent, List<CategoryWithParentId> allCategories) {
        CategoryWithChildren categoryWithChildren = new CategoryWithChildren();
        categoryWithChildren.setId(parent.getId());
        categoryWithChildren.setName(parent.getName());

        List<CategoryWithChildren> childrenEmptyList = new ArrayList<CategoryWithChildren>();
        categoryWithChildren.setChildren(childrenEmptyList);

        List<CategoryWithParentId> children = allCategories.stream().filter(x -> x.getParentCategoryId() == parent.getId()).collect(Collectors.toList());

        for (int i = 0; i < children.size(); i++) {
            categoryWithChildren.addChild(fillChildren(children.get(i), allCategories));
        }
        return categoryWithChildren;
    }
}
