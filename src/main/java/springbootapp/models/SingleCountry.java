package springbootapp.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SingleCountry extends Country {
    private List<Location> locations;
}
