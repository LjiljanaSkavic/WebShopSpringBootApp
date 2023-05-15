package springbootapp.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "category_has_attribute")
@IdClass(springbootapp.models.entities.CategoryHasAttributeEntityPK.class)
public class CategoryHasAttributeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "attribute_id", nullable = false)
    private Integer attributeId;

//    @ManyToOne
//    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
//    private CategoryEntity categoryByCategoryId;
//
//    @ManyToOne
//    @JoinColumn(name = "attribute_id", referencedColumnName = "id", nullable = false)
//    private AttributeEntity attributeByAttributeId;
}
