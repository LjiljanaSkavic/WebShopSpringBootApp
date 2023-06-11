package springbootapp.models;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CommentRequest {
    private String content;
    private Timestamp dateTime;
    private Integer productId;
    private Integer userId;
}
