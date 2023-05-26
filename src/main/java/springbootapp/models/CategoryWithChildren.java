package springbootapp.models;

import lombok.Data;

import java.util.List;

@Data
public class CategoryWithChildren {
    private Integer id;
    private String name;
    private List<CategoryWithChildren> children;

    public void addChild(CategoryWithChildren c) {
        this.children.add(c);
    }
}
