package springbootapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootapp.exceptions.NotFoundException;
import springbootapp.models.Location;
import springbootapp.models.SingleLocation;
import springbootapp.services.LocationService;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    List<Location> findAll() {
        return locationService.findAll();
    }

    @GetMapping("/{id}")
    public SingleLocation findById(@PathVariable Integer id) throws NotFoundException {
        return locationService.findById(id);
    }
}
