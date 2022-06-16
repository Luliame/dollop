package com.example.dollop.model.dto;

import org.bson.types.ObjectId;

import com.example.dollop.model.Comment;
import com.example.dollop.service.impl.UserServiceImpl;
import static org.apache.http.util.TextUtils.isEmpty;

public class CommentDto extends DtoBase<Comment> {

    //#region [ Attributes ]
    private UserDto user;

    private int note;
    
    private String contente;
    //#endregion

    //#region [ Constructor ]
    public CommentDto(Comment comment) {
        this.id = comment.getId().toString();
        this.user = UserServiceImpl
            .findByIdStatic(comment.getUserId().toString());
        this.note = comment.getNote();
        this.contente = comment.getContente();
    }

    public CommentDto(UserDto user, int note) {
        super();
        this.user = user;
        this.note = note;
    }

    public CommentDto(UserDto user, int note, String contente) {
        this(user, note);
        this.contente = contente;
    }
    //#endregion

    //#region [ getter / setter ]
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
    //#endregion

    //#region [ override ]
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
    //#endregion
}
