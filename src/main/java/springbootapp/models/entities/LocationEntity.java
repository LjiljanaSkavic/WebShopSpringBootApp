package springbootapp.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import springbootapp.base.BaseEntity;

import java.util.List;

@Data
@Entity
@Table(name = "location")
public class LocationEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "street_address", nullable = false, length = 45)
    private String streetAddress;

    @Basic
    @Column(name = "street_number", nullable = false)
    private Integer streetNumber;

    @Basic
    @Column(name = "postal_code", nullable = false, length = 45)
    private String postalCode;

    @Basic
    @Column(name = "city", nullable = false, length = 45)
    private String city;

    @OneToMany(mappedBy = "location")
    @JsonIgnore
    private List<UserEntity> usersById;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    private CountryEntity country;

}
