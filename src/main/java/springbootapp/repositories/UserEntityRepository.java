package springbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import springbootapp.models.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {

    @Query("select u.username from UserEntity u")
    List<String> getAllUsernames();

    @Query("select u from UserEntity u where u.username=:username and u.password=:password")
    Optional<UserEntity> getUserEntityByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
