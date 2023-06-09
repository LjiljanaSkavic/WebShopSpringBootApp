package springbootapp.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import springbootapp.base.BaseEntity;

@Data
@Entity
@Table(name = "product_has_attribute_value")
public class ProductHasAttributeValueEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Id
    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Id
    @Column(name = "attribute_value_id", nullable = false)
    private Integer attributeValueId;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private ProductEntity productByProductId;

    @ManyToOne
    @JoinColumn(name = "attribute_value_id", referencedColumnName = "id", nullable = false)
    private AttributeValueEntity productByAttributeValueId;
}
