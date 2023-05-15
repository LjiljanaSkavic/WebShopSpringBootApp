package springbootapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootapp.exceptions.NotFoundException;
import springbootapp.models.Category;
import springbootapp.services.AttributeService;
import springbootapp.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    private final AttributeService attributeService;

    public CategoryController(CategoryService categoryService, AttributeService attributeService) {
        this.categoryService = categoryService;
        this.attributeService = attributeService;
    }

    @GetMapping
    List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Integer id) throws NotFoundException {
        return categoryService.findById(id);
    }

//    @GetMapping("/{id}/attributes")
//    public List<Attribute> getAllAttributesByLocationId(@PathVariable Integer id) throws NotFoundException {
//        return attributeService.getAllAttributesByCategoryId(id);
//    }

}
