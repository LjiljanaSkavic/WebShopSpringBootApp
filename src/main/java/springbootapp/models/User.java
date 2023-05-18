package springbootapp.models;

import lombok.Data;
import springbootapp.models.entities.CountryEntity;
import springbootapp.models.entities.LocationEntity;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean isLoggedIn;
    private CountryEntity country;
    private LocationEntity location;
}
