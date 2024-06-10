package com.example.forum.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import java.util.List;
@Entity
@Access(AccessType.PROPERTY)
public class Topic {
    private Long id;
    private String name;
    private List<Post> posts;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
