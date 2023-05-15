package springbootapp.models;

import lombok.Data;

@Data
public class Location {
    private Integer id;
    private String streetAddress;
    private Integer streetNumber;
    private String postalCode;
    private String city;
}
