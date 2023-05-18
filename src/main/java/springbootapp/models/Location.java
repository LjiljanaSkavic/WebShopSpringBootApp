package springbootapp.models;

import lombok.Data;
import springbootapp.models.entities.CountryEntity;

@Data
public class Location {
    private Integer id;
    private String streetAddress;
    private Integer streetNumber;
    private String postalCode;
    private String city;
    private CountryEntity country;
}
