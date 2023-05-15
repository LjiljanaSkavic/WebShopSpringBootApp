package springbootapp.models;

import lombok.Data;

@Data
public class Message {
    private Integer id;
    private String text;
    private Boolean isRead;
}
