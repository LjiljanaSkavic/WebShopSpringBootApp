package springbootapp.models;

import lombok.Data;
import springbootapp.models.entities.CategoryEntity;
import springbootapp.models.entities.UserEntity;

@Data
public class Product {
    private Integer id;
    private String title;
    private String description;
    private Double price;
    private Boolean isNew;
    private String image;
    private Boolean isDeleted;
    private UserEntity sellerUser;
    private CategoryEntity category;
}
