package springbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import springbootapp.models.entities.ProductEntity;

import java.util.List;

public interface ProductEntityRepository extends JpaRepository<ProductEntity, Integer> {

    @Query("select p from ProductEntity p where p.category.id=:id")
    List<ProductEntity> getAllFromCategory(@Param("id") Integer id);
}
