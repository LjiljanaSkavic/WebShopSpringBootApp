package springbootapp.models;

import lombok.Data;

@Data
public class CategoryWithParentId {
    private Integer id;
    private String name;
    private Integer parentCategoryId;

    public CategoryWithParentId() {
    }

    public CategoryWithParentId(Integer id, String name, Integer parentCategoryId) {
        this.id = id;
        this.name = name;
        this.parentCategoryId = parentCategoryId;
    }
}
