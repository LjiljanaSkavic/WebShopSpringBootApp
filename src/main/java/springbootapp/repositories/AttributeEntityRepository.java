package springbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import springbootapp.models.entities.AttributeEntity;

import java.util.List;

public interface AttributeEntityRepository extends JpaRepository<AttributeEntity, Integer> {

    @Query("SELECT a FROM AttributeEntity a JOIN CategoryHasAttributeEntity cha ON a.id = cha.attributeId WHERE cha.categoryId =:categoryId")
    List<AttributeEntity> getAllByCategoryId(@Param("categoryId") Integer categoryId);
}
