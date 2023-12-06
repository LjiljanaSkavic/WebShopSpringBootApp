package springbootapp.controllers;

import org.springframework.web.bind.annotation.*;
import springbootapp.base.CrudController;
import springbootapp.models.User;
import springbootapp.models.entities.CountryEntity;
import springbootapp.models.entities.LocationEntity;
import springbootapp.services.implementation.CountryServiceImplementation;
import springbootapp.services.implementation.LocationServiceImplementation;
import springbootapp.services.implementation.UserServiceImplementation;

@RestController
@RequestMapping("/users")
public class UserController extends CrudController<Integer, User, User> {
    UserServiceImplementation userService;
    LocationServiceImplementation locationService;
    CountryServiceImplementation countryService;

    public UserController(UserServiceImplementation userService, LocationServiceImplementation locationService, CountryServiceImplementation countryService) {
        super(User.class, userService);
        this.userService = userService;
        this.locationService = locationService;
        this.countryService = countryService;
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Integer id, @RequestBody User modifiedUser) {

        User existingUser = userService.findById(id, User.class);

        existingUser.setUsername(modifiedUser.getUsername());
        existingUser.setPassword(modifiedUser.getPassword());
        existingUser.setFirstName(modifiedUser.getFirstName());
        existingUser.setLastName(modifiedUser.getLastName());
        existingUser.setEmail(modifiedUser.getEmail());
        existingUser.setImageAvatar(modifiedUser.getImageAvatar());
        existingUser.setActivationPin(modifiedUser.getActivationPin());
        existingUser.setIsActivated(modifiedUser.getIsActivated());

        if (modifiedUser.getLocation() != null) {
            LocationEntity newLocation = locationService.findById(modifiedUser.getLocation().getId(), LocationEntity.class);

            if (newLocation != null) {
                boolean newCountry = countryService.findByName(modifiedUser.getLocation().getCountry().getName());
                if (newCountry) {
                    countryService.update(modifiedUser.getLocation().getCountry().getId(), modifiedUser.getLocation().getCountry(), CountryEntity.class);
                } else {
                    countryService.insert(modifiedUser.getLocation().getCountry(), CountryEntity.class);
                }
                locationService.update(modifiedUser.getLocation().getId(), modifiedUser.getLocation(), LocationEntity.class);
            } else {
                boolean newCountry = countryService.findByName(modifiedUser.getLocation().getCountry().getName());
                if (newCountry) {
                    countryService.update(modifiedUser.getLocation().getCountry().getId(), modifiedUser.getLocation().getCountry(), CountryEntity.class);
                } else {
                    countryService.insert(modifiedUser.getLocation().getCountry(), CountryEntity.class);
                }
                locationService.insert(modifiedUser.getLocation(), LocationEntity.class);
            }
        }

        User updatedUser = userService.update(existingUser.getId(), existingUser, User.class);
        return updatedUser;
    }
}
