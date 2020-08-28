package com.myposts.services.posts;

import com.myposts.services.users.User;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "posts")
@Data
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private String content;

    private boolean isPrivate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Post() {
    }

    public Post(String content, boolean isPrivate, User user) {
        this.content = content;
        this.isPrivate = isPrivate;
        this.user = user;
        this.createDate = new Date();
    }

}

