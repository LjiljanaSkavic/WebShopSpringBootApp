package springbootapp.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "message")
public class MessageEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Basic
    @Column(name = "text", nullable = false, length = 500)
    private String text;

    @Basic
    @Column(name = "is_read", nullable = false)
    private Boolean isRead;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_user_id", referencedColumnName = "id", nullable = false)
    private UserEntity senderUser;

}
