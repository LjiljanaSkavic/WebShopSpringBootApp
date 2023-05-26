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
        List<CategoryEntity> all = this.repository.getAllCustomMethod().stream().map(e -> modelMapper.map(e, CategoryEntity.class)).collect(Collectors.toList());

        List<CategoryWithParentId> allCategories = this.repository.getAllCustomMethod().stream().map(e -> modelMapper.map(e, CategoryWithParentId.class)).collect(Collectors.toList());
        List<CategoryWithParentId> root = allCategories.stream().filter(categoryWithParentId -> categoryWithParentId.getParentCategoryId() == null).collect(Collectors.toList());

        List<CategoryWithChildren> result = new ArrayList<CategoryWithChildren>();
        for (int i = 0; i < root.size(); i++) {
            result.add(fillChildren(root.get(i), allCategories));
        }
        return result;
    }

    private CategoryWithChildren fillChildren(CategoryWithParentId parent, List<CategoryWithParentId> allCategories) {
        var dto = new CategoryWithChildren();
        dto.setId(parent.getId());
        dto.setName(parent.getName());

        List<CategoryWithChildren> childrenEmptyList = new ArrayList<CategoryWithChildren>();
        dto.setChildren(childrenEmptyList);

        List<CategoryWithParentId> children = allCategories.stream().filter(x -> x.getParentCategoryId() == parent.getId()).collect(Collectors.toList());

        for (int i = 0; i < children.size(); i++) {
            dto.addChild(fillChildren(children.get(i), allCategories));
        }
        return dto;
    }

    private List<CategoryWithParentId> getAllMapped(List<CategoryEntity> all) {
        return all.stream()
                .map(category -> {
                    Integer parentCategory = null;
                    if (category.getParentCategory() != null) {
                        parentCategory = category.getParentCategory().getId();
                    }
                    return new CategoryWithParentId(category.getId(), category.getName(), parentCategory);
                })
                .collect(Collectors.toList());
    }
}
