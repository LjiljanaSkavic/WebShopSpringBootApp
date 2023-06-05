package springbootapp.models;

import lombok.Data;
import springbootapp.models.entities.UserEntity;

@Data
public class Message {
    private Integer id;
    private String text;
    private Boolean isRead;
    private UserEntity senderUser;
}
