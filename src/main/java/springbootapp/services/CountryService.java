package springbootapp.services;

import springbootapp.exceptions.NotFoundException;
import springbootapp.models.Country;
import springbootapp.models.SingleCountry;

import java.util.List;

public interface CountryService {
    List<Country> findAll();

    SingleCountry findById(Integer id) throws NotFoundException;
}
