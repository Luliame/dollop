package com.example.dollop.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("comment")
public class Comment {

    //#region [ Attributes ]
    private ObjectId id;

    private ObjectId userId;

    private int note;
    
    private String contente;
    //#endregion

    //#region [ Constructor ]
    public Comment() {
        id = new ObjectId();
    }

    public Comment(ObjectId userId, int note) {
        this();
        this.userId = userId;
        this.note = note;
    }

    public Comment(ObjectId userId, int note, String contexte) {
        this();
        this.userId = userId;
        this.note = note;
        this.contente = contexte;
    }

    public Comment(ObjectId id, ObjectId userId, int note, String contexte) {
        this.id = id;
        this.userId = userId;
        this.note = note;
        this.contente = contexte;
    }
    //#endregion

    //#region [ getter / setter ]
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

    public String getContente() {
        return contente;
    }

    public void setContente(String contexte) {
        this.contente = contexte;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
    //#endregion
}
