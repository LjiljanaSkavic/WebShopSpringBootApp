package springbootapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootapp.base.CrudController;
import springbootapp.models.Category;
import springbootapp.models.CategoryRequest;
import springbootapp.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController extends CrudController<Integer, CategoryRequest, Category> {
    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        super(Category.class, categoryService);
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}/children")
    List<Category> getCategoryChildren(@PathVariable Integer id) {
        return categoryService.getAllByParentCategoryId(id);
    }
}
