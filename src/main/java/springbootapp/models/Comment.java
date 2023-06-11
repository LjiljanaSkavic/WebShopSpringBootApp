package springbootapp.models;

import lombok.Data;
import springbootapp.models.entities.UserEntity;

import java.sql.Timestamp;

@Data
public class Comment {
    private Integer id;
    private String content;
    private Timestamp dateTime;
    private Boolean isModified;
    private Boolean isDeleted;
    private UserEntity user;
}
