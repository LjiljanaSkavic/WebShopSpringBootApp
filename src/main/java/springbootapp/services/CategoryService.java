package springbootapp.services;

import springbootapp.exceptions.NotFoundException;
import springbootapp.models.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(Integer id) throws NotFoundException;

}
