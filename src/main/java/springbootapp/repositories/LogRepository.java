package springbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootapp.models.entities.LogEntity;

public interface LogRepository extends JpaRepository<LogEntity, Integer> {
}
