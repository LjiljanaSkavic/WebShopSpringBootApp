package springbootapp.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import springbootapp.base.BaseEntity;

@Data
@Entity
@Table(name = "product")
public class ProductEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Basic
    @Column(name = "description", nullable = false, length = 1000)
    private String description;

    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    private Double price;

    @Basic
    @Column(name = "is_new", nullable = false)
    private Boolean isNew;

    @Basic
    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

    @Basic
    @Column(name = "image", nullable = false, length = 500)
    private String image;

    @ManyToOne
    @JoinColumn(name = "seller_user_id", referencedColumnName = "id", nullable = false)
    private UserEntity sellerUser;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private CategoryEntity category;
}
