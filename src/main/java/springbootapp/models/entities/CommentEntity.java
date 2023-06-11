package springbootapp.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import springbootapp.base.BaseEntity;

import java.sql.Timestamp;


@Data
@Entity
@Table(name = "comment")
public class CommentEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "content", nullable = false, length = 500)
    private String content;

    @Basic
    @Column(name = "is_modified", nullable = false)
    private Boolean isModified = false;

    @Basic
    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;

    @Basic
    @DateTimeFormat
    @Column(name = "date_time")
    private Timestamp dateTime;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false)
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserEntity user;
}
