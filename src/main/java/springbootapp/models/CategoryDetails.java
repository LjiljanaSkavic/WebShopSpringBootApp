package springbootapp.models;

import springbootapp.models.entities.CategoryEntity;

public class CategoryDetails {

    //TODO: Check how to implement this
    private Integer id;
    private String name;
    private CategoryEntity[] children;

    public CategoryDetails(Integer id, String name, CategoryEntity[] allByParentCategoryId) {
        this.id = id;
        this.name = name;
        this.children = allByParentCategoryId;
    }
}
