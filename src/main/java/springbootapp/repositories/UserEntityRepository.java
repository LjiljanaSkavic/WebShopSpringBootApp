package springbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

    @Modifying
    @Query("update UserEntity u set u.isActivated=true where u.id=:id")
    void activateUser(@Param("id") Integer id);

    @Modifying
    @Query("update UserEntity u set u.isLoggedIn=true where u.id=:id")
    void loginUser(@Param("id") Integer id);
}
