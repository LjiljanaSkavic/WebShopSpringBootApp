package springbootapp.models.entities;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "log")
public class LogEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "content")
    private String content;
    @Basic
    @DateTimeFormat
    @Column(name = "date_time")
    private Timestamp dateTime;

    public LogEntity(Integer id, String content, Timestamp dateTime) {
        this.id = id;
        this.content = content;
        this.dateTime = dateTime;
    }

    public LogEntity(String content, Timestamp dateTime) {
        this.content = content;
        this.dateTime = dateTime;
    }

    public LogEntity() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogEntity logEntity = (LogEntity) o;
        return id == logEntity.id && Objects.equals(content, logEntity.content) && Objects.equals(dateTime, logEntity.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, dateTime);
    }
}
