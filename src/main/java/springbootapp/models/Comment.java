package springbootapp.models;

import java.util.Date;

public class Comment {
    private Integer id;
    private String content;
    private Date date;
    private Boolean isModified;
    private Integer isDeleted;

    private User user;
}
