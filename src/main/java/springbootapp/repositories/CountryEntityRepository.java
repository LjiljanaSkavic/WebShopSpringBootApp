package springbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootapp.models.entities.CountryEntity;

public interface CountryEntityRepository extends JpaRepository<CountryEntity, Integer> {
}
