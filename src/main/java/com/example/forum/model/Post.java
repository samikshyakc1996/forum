package com.example.forum.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import java.time.LocalDateTime;
@Entity
@Access(AccessType.PROPERTY)
public class Post {

   private long id;
   private String title;
   private String content;
    private User user;
    private LocalDateTime createdAt;
    //private List<Comment> comments
    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
