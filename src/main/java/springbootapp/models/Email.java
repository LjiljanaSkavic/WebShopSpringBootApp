package springbootapp.models;

import lombok.Data;

@Data
public class Email {
    private String receiver;
    private String content;

    public Email() {
    }

    public Email(String receiver, Integer content) {
        this.receiver = receiver;
        this.content = content.toString();
    }
}
