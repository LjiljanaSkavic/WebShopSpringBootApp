package springbootapp.models;

import lombok.Data;

@Data
public class MessageRequest {
    private String text;
    private Boolean isRead;
    private Integer senderUserId;
}
