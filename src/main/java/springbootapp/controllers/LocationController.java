package springbootapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootapp.base.CrudController;
import springbootapp.models.Location;
import springbootapp.models.LocationRequest;
import springbootapp.services.LocationService;

@RestController
@RequestMapping("/locations")
public class LocationController extends CrudController<Integer, LocationRequest, Location> {

    public LocationController(LocationService locationService) {
        super(Location.class, locationService);
    }
}
