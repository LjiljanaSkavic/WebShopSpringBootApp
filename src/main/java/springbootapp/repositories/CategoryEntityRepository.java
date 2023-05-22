package springbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import springbootapp.models.entities.CategoryEntity;

import java.util.List;

public interface CategoryEntityRepository extends JpaRepository<CategoryEntity, Integer> {

    @Query("select c from CategoryEntity c where c.parentCategory.id=:parent_category_id")
    List<CategoryEntity> getAllByParentCategoryId(@Param("parent_category_id") Integer parent_category_id);

}
