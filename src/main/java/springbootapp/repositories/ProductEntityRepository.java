package springbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import springbootapp.models.entities.ProductEntity;

import java.util.List;

public interface ProductEntityRepository extends JpaRepository<ProductEntity, Integer> {

    @Query("select p from ProductEntity p where p.category.id=:id")
    List<ProductEntity> getByCategoryId(@Param("id") Integer id);

    @Query("select p from ProductEntity p where p.title LIKE '%<query>%' or p.description like '%<query>%'")
    List<ProductEntity> getByProductTitle(@Param("query") String query);

    @Query("select p from ProductEntity p where p.title LIKE '%<query>%' or p.description like '%<query>%' and p.id=:id")
    List<ProductEntity> getByCategoryIdAndProductTitle(@Param("id") Integer id, @Param("query") String query);
}
