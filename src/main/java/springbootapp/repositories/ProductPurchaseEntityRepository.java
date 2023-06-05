package springbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springbootapp.models.entities.ProductPurchaseEntity;

import java.util.List;

public interface ProductPurchaseEntityRepository extends JpaRepository<ProductPurchaseEntity, Integer> {
    @Query("select p from ProductPurchaseEntity p where p.user.id=:id")
    List<ProductPurchaseEntity> getByCustomerId(Integer id);
}
