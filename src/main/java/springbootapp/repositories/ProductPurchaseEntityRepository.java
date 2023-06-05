package springbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import springbootapp.models.entities.ProductPurchaseEntity;

import java.util.List;

public interface ProductPurchaseEntityRepository extends JpaRepository<ProductPurchaseEntity, Integer> {
    @Query("select p from ProductPurchaseEntity p where p.user.id=:id and p.isDeleted=false")
    List<ProductPurchaseEntity> getByCustomerId(Integer id);

    @Modifying
    @Query("update ProductPurchaseEntity pp set pp.isDeleted=true where pp.id=:id")
    void markAsDeletedById(Integer id);
}
