package springbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootapp.models.entities.LocationEntity;

public interface LocationEntityRepository extends JpaRepository<LocationEntity, Integer> {
}
