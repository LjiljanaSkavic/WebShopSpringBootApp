package springbootapp.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import springbootapp.base.CrudJpaService;
import springbootapp.models.entities.LocationEntity;
import springbootapp.services.LocationService;

@Service
public class LocationServiceImplementation extends CrudJpaService<LocationEntity, Integer> implements LocationService {

    public LocationServiceImplementation(JpaRepository<LocationEntity, Integer> repository, ModelMapper modelMapper) {
        super(repository, modelMapper, LocationEntity.class);
    }
}