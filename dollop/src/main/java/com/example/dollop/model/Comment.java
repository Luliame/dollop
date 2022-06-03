package com.example.dollop.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("comment")
public class Comment {

    private ObjectId id;

    // public User user;
    public ObjectId userId;

    public int note;
    
    public String contexte;

    public Comment() {
        id = new ObjectId();
    }

    public Comment(ObjectId userId, int note) {
        this();
        // this.user = user;
        this.userId = userId;
        this.note = note;
    }

    public Comment(ObjectId userId, int note, String contexte) {
        this();
        // this.user = user;
        this.userId = userId;
        this.note = note;
        this.contexte = contexte;
    }

    public Comment(ObjectId id, ObjectId userId, int note, String contexte) {
        this.id = id;
        // this.user = user;
        this.userId = userId;
        this.note = note;
        this.contexte = contexte;
    }

    // public User getUser() {
    //     return user;
    // }

    // public void setUser(User user) {
    //     this.user = user;
    // }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getContexte() {
        return contexte;
    }

    public void setContexte(String contexte) {
        this.contexte = contexte;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}
