package springbootapp.models;

import lombok.Data;

@Data
public class CategoryWithParentId {
    private Integer id;
    private String name;
    private Integer parentCategoryId;
}
