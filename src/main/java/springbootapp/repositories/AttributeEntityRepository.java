package springbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import springbootapp.models.AttributeValueKeys;
import springbootapp.models.entities.AttributeEntity;

import java.util.List;

public interface AttributeEntityRepository extends JpaRepository<AttributeEntity, Integer> {

    @Query("SELECT a FROM AttributeEntity a JOIN CategoryHasAttributeEntity cha ON a.id = cha.attributeId WHERE cha.categoryId =:categoryId")
    List<AttributeEntity> getAllByCategoryId(@Param("categoryId") Integer categoryId);

    @Query("SELECT new springbootapp.models.AttributeValueKeys(a.id, a.name, av.id, av.value) FROM ProductEntity p JOIN CategoryEntity c ON p.category.id = c.id JOIN CategoryHasAttributeEntity cha ON c.id = cha.categoryId JOIN AttributeEntity a ON cha.attributeId = a.id JOIN AttributeValueEntity av ON av.attributeId = a.id JOIN ProductHasAttributeValueEntity phav ON av.id = phav.attributeValueId and phav.productId = p.id WHERE p.id=:productId")
    List<AttributeValueKeys> getAllByProductId(@Param("productId") Integer productId);
}
