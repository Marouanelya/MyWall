package com.polytech.business;


import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by dev on 3/13/17.
 */
@Entity
@Table(name = "POSTS")
public class Post {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "USERNAME")
    private String username;

    @Transient
    private long likes;

    @Transient
    private List<Comment> comments;

    public Post(){}

    public Post(String username, String content) {
        this.setUsername(username);
        this.setContent(content);
    }

    @Override
    public String toString() {
        return getContent();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
