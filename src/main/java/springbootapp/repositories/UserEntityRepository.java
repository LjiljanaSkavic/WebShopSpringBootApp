package springbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootapp.models.entities.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {

//    @Query("select u.username from UserEntity u")
//    List<String> getAllUsernames();
//
//    @Query("select u from UserEntity u where u.username = :username and u.password= :password")
//    UserEntity getUserEntityByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
