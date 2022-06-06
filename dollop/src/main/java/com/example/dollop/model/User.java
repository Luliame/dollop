package com.example.dollop.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
public class User {

    private ObjectId id;

    private String userName;
    
    private List<Article> favorites = new ArrayList<>();

    
    public User() {
        id = new ObjectId();
    }

    public User(String userName) {
        this.userName = userName;
    }

    public User(String userName, List<Article> favorites) {
        this();
        this.userName = userName;
        this.favorites = favorites;
    }

    public User(ObjectId _id, String userName, List<Article> favorites) {
        this.id = _id;
        this.userName = userName;
        this.favorites = favorites;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId _id) {
        this.id = _id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Article> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Article> favorites) {
        this.favorites = favorites;
    }
}
