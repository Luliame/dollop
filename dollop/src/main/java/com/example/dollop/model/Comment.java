package com.example.dollop.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("comment")
public class Comment {

    private ObjectId _id;

    public User user;

    public int note;
    
    public String contexte;

    public Comment() {
        _id = new ObjectId();
    }

    public Comment(User user, int note) {
        this();
        this.user = user;
        this.note = note;
    }

    public Comment(User user, int note, String contexte) {
        this();
        this.user = user;
        this.note = note;
        this.contexte = contexte;
    }

    public Comment(ObjectId _id, User user, int note, String contexte) {
        this._id = _id;
        this.user = user;
        this.note = note;
        this.contexte = contexte;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }
}
