package springbootapp.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springbootapp.base.CrudJpaService;
import springbootapp.models.entities.LocationEntity;
import springbootapp.repositories.LocationEntityRepository;
import springbootapp.services.LocationService;

@Service
public class LocationServiceImplementation extends CrudJpaService<LocationEntity, Integer> implements LocationService {

    public LocationServiceImplementation(LocationEntityRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper, LocationEntity.class);
    }
}