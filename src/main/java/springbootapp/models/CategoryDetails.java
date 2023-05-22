package springbootapp.models;

import springbootapp.models.entities.CategoryEntity;

public class CategoryDetails {
    private Integer id;
    private String name;
    private CategoryEntity[] children;
}
