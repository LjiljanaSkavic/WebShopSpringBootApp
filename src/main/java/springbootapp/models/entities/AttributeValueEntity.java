package springbootapp.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "attribute_value")
public class AttributeValueEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "value", nullable = false, length = 200)
    private String value;

    @Basic
    @Column(name = "attribute_id", nullable = false)
    private Integer attributeId;

}
