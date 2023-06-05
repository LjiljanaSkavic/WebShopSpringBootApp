package springbootapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import springbootapp.models.entities.MessageEntity;

public interface ContactSupportRepository extends JpaRepository<MessageEntity, Integer> {
}
