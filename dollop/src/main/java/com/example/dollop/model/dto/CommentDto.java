package com.example.dollop.model.dto;

import org.bson.types.ObjectId;

import com.example.dollop.model.Comment;
import com.example.dollop.service.impl.UserServiceImpl;
import static org.apache.http.util.TextUtils.isEmpty;

public class CommentDto extends DtoBase<Comment> {

    private String id;

    private UserDto user;

    private int note;
    
    private String contente;

    public CommentDto(Comment comment) {
        this.id = comment.getId().toString();
        this.user = UserServiceImpl
            .findByIdStatic(comment.getUserId().toString());
        this.note = comment.getNote();
        this.contente = comment.getContente();
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

    public String getContente() {
        return contente;
    }

    public void setContente(String contexte) {
        this.contente = contexte;
    }

    @Override
    public Comment toModel() {
        return new Comment(
            new ObjectId(id),
            new ObjectId(user.getId()),
            note,
            contente
        );
    }

    @Override
    public boolean isValidNew() {
        return isEmpty(id) &&
            user != null &&
            note >= 0 && 
            note <= 10;
    }
    
}
