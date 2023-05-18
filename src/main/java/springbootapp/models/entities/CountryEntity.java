package springbootapp.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import springbootapp.base.BaseEntity;

import java.util.List;

@Data
@Entity
@Table(name = "country")
public class CountryEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @OneToMany(mappedBy = "country")
    private List<LocationEntity> locations;

    @OneToMany(mappedBy = "country")
    private List<UserEntity> users;
}
