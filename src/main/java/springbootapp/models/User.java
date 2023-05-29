package springbootapp.models;

import lombok.Data;
import springbootapp.models.entities.LocationEntity;

@Data
public class User {
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private Integer activationPin;
    private Boolean isLoggedIn;
    private Boolean isActivated;
    private LocationEntity location;

    public User() {

    }
}
