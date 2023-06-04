package springbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import springbootapp.models.entities.ProductEntity;

import java.util.List;

public interface ProductEntityRepository extends JpaRepository<ProductEntity, Integer> {

    @Query("select p from ProductEntity p where p.category.id=:id and p.isDeleted=false")
    List<ProductEntity> getByCategoryId(@Param("id") Integer id);

    //TODO: Check how to write this correctly
//    @Query("WITH RECURSIVE category_tree AS (" +
//            "SELECT c.id FROM CategoryEntity c WHERE c.id=:id " +
//            "UNION ALL " +
//            "SELECT ce.id FROM CategoryEntity ce" +
//            "JOIN category_tree ct ON c.parent_category_id = ct.id" +
//            ")" +
//            "SELECT p.*" +
//            "FROM ProductEntity p" +
//            "JOIN category_tree ct ON p.category_id = ct.id")
//    List<ProductEntity> getAllByCategoryId(@Param("id") Integer id);

    @Query("select p from ProductEntity p where p.title LIKE CONCAT('%', :query ,'%') and p.isDeleted=false")
    List<ProductEntity> getByProductTitle(@Param("query") String query);

    @Query("select p from ProductEntity p where p.title LIKE CONCAT('%', :query ,'%') and p.id=:id and p.isDeleted=false")
    List<ProductEntity> getByCategoryIdAndProductTitle(@Param("id") Integer id, @Param("query") String query);

    @Query("select p from ProductEntity p where p.sellerUser.id=:id")
    List<ProductEntity> getBySellerId(Integer id);

    @Modifying
    @Query("update ProductEntity p set p.isDeleted=true where p.id=:id")
    void markAsDeletedById(Integer id);
}
