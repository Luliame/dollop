package com.example.dollop.model.dto;

import org.bson.types.ObjectId;

import com.example.dollop.model.Comment;
import com.example.dollop.service.impl.UserServiceImpl;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class CommentDto extends DtoBase<Comment> {

    private String id;

    public UserDto user;

    public int note;
    
    public String contexte;

    public CommentDto(Comment comment) {
        this.id = comment.getId().toString();
        this.user = UserServiceImpl.test(comment.getUserId().toString()); //TODO a tester
        this.note = comment.getNote();
        this.contexte = comment.getContexte();
    }

    public CommentDto() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
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

    @Override
    public Comment toModel() {
        return new Comment(
            new ObjectId(id),
            new ObjectId(user.getId()),
            note,
            contexte
        );
    }

    @JsonIgnore
    @Override
    public boolean isValidNew() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
