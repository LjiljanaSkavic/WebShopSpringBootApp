package springbootapp.services;

import springbootapp.exceptions.NotFoundException;
import springbootapp.models.Location;
import springbootapp.models.SingleLocation;

import java.util.List;

public interface LocationService {
    List<Location> findAll();

    SingleLocation findById(Integer id) throws NotFoundException;
}
