package springbootapp.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import springbootapp.base.BaseEntity;

@Data
@Entity
@Table(name = "category_has_attribute")
public class CategoryHasAttributeEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Id
    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

    @Id
    @Column(name = "attribute_id", nullable = false)
    private Integer attributeId;

    //TODO: Check how to show this connections with Andjelina
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private CategoryEntity categoryByCategoryId;

    @ManyToOne
    @JoinColumn(name = "attribute_id", referencedColumnName = "id", nullable = false)
    private AttributeEntity attributeByAttributeId;
}
