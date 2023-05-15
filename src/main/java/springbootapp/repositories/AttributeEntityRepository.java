package springbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootapp.models.entities.AttributeEntity;

public interface AttributeEntityRepository extends JpaRepository<AttributeEntity, Integer> {
//    List<AttributeEntity> getAllByCategory_Id(Integer id);
}
