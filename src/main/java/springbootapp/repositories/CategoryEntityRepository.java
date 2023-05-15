package springbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootapp.models.entities.CategoryEntity;

public interface CategoryEntityRepository extends JpaRepository<CategoryEntity, Integer> {
}
