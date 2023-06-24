package springbootapp.models;

import lombok.Data;

@Data
public class Email {
    private String receiver;
    private String content;
}
