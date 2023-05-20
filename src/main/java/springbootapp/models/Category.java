package springbootapp.models;

import lombok.Data;
import springbootapp.models.entities.CategoryEntity;

@Data
public class Category {
    private Integer id;
    private String name;
    private CategoryEntity parentCategory;
}
