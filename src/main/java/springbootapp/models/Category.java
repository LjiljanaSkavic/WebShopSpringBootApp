package springbootapp.models;

import lombok.Data;

@Data
public class Category {
    private Integer id;
    private String name;
    private Integer subcategoryId;
}
