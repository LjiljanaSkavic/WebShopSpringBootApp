package springbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import springbootapp.models.entities.CommentEntity;

import java.util.List;

public interface CommentEntityRepository extends JpaRepository<CommentEntity, Integer> {

    @Query("select c from CommentEntity c where c.product.id=:productId")
    List<CommentEntity> getAllByProductId(@Param("productId") Integer productId);
}
