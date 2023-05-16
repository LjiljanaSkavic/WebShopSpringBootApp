package springbootapp.models;

import lombok.Data;

@Data
public class ProductRequest {
    private String title;
    private String description;
    private Double price;
    private Boolean isNew;
    //TODO: Check with Andjelina how to handle this
    private Integer categoryId;
    private Integer sellerUserId;
}
