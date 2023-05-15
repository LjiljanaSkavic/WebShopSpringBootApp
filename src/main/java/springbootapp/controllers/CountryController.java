package springbootapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootapp.exceptions.NotFoundException;
import springbootapp.models.Country;
import springbootapp.models.SingleCountry;
import springbootapp.services.CountryService;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    List<Country> findAll() {
        return countryService.findAll();
    }

    @GetMapping("/{id}")
    public SingleCountry findById(@PathVariable Integer id) throws NotFoundException {
        return countryService.findById(id);
    }

}
