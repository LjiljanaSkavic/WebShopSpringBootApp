package springbootapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootapp.base.CrudController;
import springbootapp.models.Category;
import springbootapp.models.CategoryRequest;
import springbootapp.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController extends CrudController<Integer, CategoryRequest, Category> {
    public CategoryController(CategoryService categoryService) {
        super(Category.class, categoryService);
    }

}
