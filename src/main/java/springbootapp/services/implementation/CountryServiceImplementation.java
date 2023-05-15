package springbootapp.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springbootapp.exceptions.NotFoundException;
import springbootapp.models.Country;
import springbootapp.models.SingleCountry;
import springbootapp.repositories.CountryEntityRepository;
import springbootapp.services.CountryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImplementation implements CountryService {

    private ModelMapper modelMapper;

    private final CountryEntityRepository repository;

    public CountryServiceImplementation(CountryEntityRepository repository, ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    @Override
    public List<Country> findAll() {
        return repository.findAll().stream().map(countryEntity -> modelMapper.map(countryEntity, Country.class)).collect(Collectors.toList());
    }

    @Override
    public SingleCountry findById(Integer id) throws NotFoundException {
        return modelMapper.map(repository.findById(id).orElseThrow(NotFoundException::new), SingleCountry.class);
    }
}
