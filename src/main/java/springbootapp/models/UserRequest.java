package springbootapp.models;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Integer activationPin;
}
