package springbootapp.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springbootapp.base.CrudJpaService;
import springbootapp.models.entities.CountryEntity;
import springbootapp.repositories.CountryEntityRepository;
import springbootapp.services.CountryService;

@Service
public class CountryServiceImplementation extends CrudJpaService<CountryEntity, Integer> implements CountryService {

    public CountryServiceImplementation(CountryEntityRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper, CountryEntity.class);
    }
}