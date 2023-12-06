package springbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import springbootapp.models.entities.CountryEntity;

import java.util.Optional;

public interface CountryEntityRepository extends JpaRepository<CountryEntity, Integer> {

    @Query("select c from CountryEntity c where c.name=:name")
    Optional<CountryEntity> getCountryEntityByName(@Param("name") String name);
}
