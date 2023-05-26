package springbootapp.services;

import springbootapp.base.CrudService;
import springbootapp.models.Category;
import springbootapp.models.CategoryWithChildren;

import java.util.List;

public interface CategoryService extends CrudService<Integer> {

    List<Category> getAllByParentCategoryId(Integer parent_category_id);

    List<CategoryWithChildren> getAllCustomMethod();
}
