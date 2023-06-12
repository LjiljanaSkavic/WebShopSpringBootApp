package springbootapp.models;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String imageAvatar;
    private Integer activationPin;
    private Boolean isActivated;
    private Boolean isLoggedIn;
    private Integer locationId;
    private Integer CountryId;
}
