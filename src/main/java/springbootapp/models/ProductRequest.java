package springbootapp.models;

import lombok.Data;

@Data
public class ProductRequest {
    private String identifier;
    private String title;
    private String description;
    private Double price;
    private Boolean isNew;
    private Integer sellerUserId;
}
