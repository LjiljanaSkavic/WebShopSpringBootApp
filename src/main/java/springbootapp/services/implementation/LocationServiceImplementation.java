package springbootapp.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springbootapp.exceptions.NotFoundException;
import springbootapp.models.Location;
import springbootapp.models.SingleLocation;
import springbootapp.repositories.LocationEntityRepository;
import springbootapp.services.LocationService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImplementation implements LocationService {

    private ModelMapper modelMapper;
    private final LocationEntityRepository repository;

    public LocationServiceImplementation(LocationEntityRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Location> findAll() {
        return repository.findAll().stream().map(locationEntity -> modelMapper.map(locationEntity, Location.class)).collect(Collectors.toList());
    }

    @Override
    public SingleLocation findById(Integer id) throws NotFoundException {
        return modelMapper.map(repository.findById(id).orElseThrow(NotFoundException::new), SingleLocation.class);
    }

}
