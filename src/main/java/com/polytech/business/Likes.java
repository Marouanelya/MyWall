package com.polytech.business;

import javax.persistence.*;

/**
 * Created by E.Marouane on 19/03/2017.
 */
@Entity
@Table(name = "LIKES")
public class Likes {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "postID")
    private long postID;

    public Likes(){}

    public Likes(long postID, String username){
        this.setPostID(postID);
        this.setUsername(username);
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getPostID() {
        return postID;
    }

    public void setPostID(long postID) {
        this.postID = postID;
    }

    @Override
    public String toString() {
        return "Like ID : " + id + "\nPostID : " + postID + "\nUserName : " + username;
    }
}
