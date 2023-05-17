package springbootapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootapp.base.CrudController;
import springbootapp.models.Country;
import springbootapp.models.CountryRequest;
import springbootapp.services.CountryService;

@RestController
@RequestMapping("/countries")
public class CountryController extends CrudController<Integer, CountryRequest, Country> {
    public CountryController(CountryService countryService) {
        super(Country.class, countryService);
    }
}
