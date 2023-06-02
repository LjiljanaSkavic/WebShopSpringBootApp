package springbootapp.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "product_purchase")
public class ProductPurchaseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "order_id", nullable = false, length = 8)
    private String orderId;

    @Basic
    @Column(name = "date_time", nullable = false)
    private Timestamp dateTime;

    @Basic
    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;

    @Basic
    @Column(name = "payment_type", nullable = false)
    private Boolean paymentType;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private ProductEntity product;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "customer_user_id", referencedColumnName = "id", nullable = false)
    private UserEntity user;
}
