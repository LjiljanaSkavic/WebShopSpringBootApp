package springbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootapp.models.entities.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {
}
