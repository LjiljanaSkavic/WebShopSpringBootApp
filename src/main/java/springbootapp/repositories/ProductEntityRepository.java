package springbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootapp.models.entities.ProductEntity;

public interface ProductEntityRepository extends JpaRepository<ProductEntity, Integer> {

}
