package com.example.dollop.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
public class User {

    public ObjectId _id;

    public String userName;
    
    public List<Article> favorites;

    
    public User() {
        _id = new ObjectId();
    }

    public User(String userName, List<Article> favorites) {
        this();
        this.userName = userName;
        this.favorites = favorites;
    }

    public User(ObjectId _id, String userName, List<Article> favorites) {
        this._id = _id;
        this.userName = userName;
        this.favorites = favorites;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
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
