package springbootapp.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import springbootapp.base.BaseEntity;

@Data
@Entity
@Table(name = "category")
public class CategoryEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_category_id", referencedColumnName = "id", nullable = true)
    private CategoryEntity parentCategory;
}
