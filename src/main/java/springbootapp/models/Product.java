package springbootapp.models;

import lombok.Data;

@Data
public class Product {
    private Integer id;
    private String title;
    private String description;
    private Double price;
    private Boolean isNew;
}
