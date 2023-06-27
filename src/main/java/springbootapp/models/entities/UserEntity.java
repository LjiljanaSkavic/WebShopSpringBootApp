package springbootapp.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import springbootapp.base.BaseEntity;

import java.util.List;

@Data
@Entity
@Table(name = "user")
public class UserEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "username", nullable = false, length = 45)
    private String username;

    @Basic
    @Column(name = "password", nullable = false, length = 45)
    private String password;

    @Basic
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Basic
    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @Basic
    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Basic
    @Column(name = "image_avatar", length = 500)
    private String imageAvatar;

    @Basic
    @Column(name = "activation_pin")
    private Integer activationPin;

    @Basic
    @Column(name = "is_logged_in", columnDefinition = "TINYINT(1)")
    private Boolean isLoggedIn;

    @Basic
    @Column(name = "is_activated", columnDefinition = "TINYINT(1)")
    private Boolean isActivated;

    @JsonIgnore
    @OneToMany(mappedBy = "senderUser")
    private List<MessageEntity> messagesById;

    @JsonIgnore
    @OneToMany(mappedBy = "sellerUser")
    private List<ProductEntity> productsById;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private CountryEntity country;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private LocationEntity location;
}
