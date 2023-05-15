package springbootapp.models;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean isLoggedIn;
}
