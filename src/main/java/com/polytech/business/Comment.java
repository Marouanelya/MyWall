package com.polytech.business;


import javax.persistence.*;

/**
 * Created by E.Marouane on 19/03/2017.
 */
@Entity
@Table(name = "COMMENTS")
public class Comment {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "username")
    private String username;

    @Column(name = "postID")
    private long postID;

    public Comment(){}

    public Comment(long postID, String username, String content){
        this.setContent(content);
        this.setUsername(username);
        this.setPostID(postID);
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getPostID() {
        return postID;
    }

    public void setPostID(long postID) {
        this.postID = postID;
    }

    @Override
    public String toString() {
        return /*postID + " : " + */username + " : " + content;
    }
}
