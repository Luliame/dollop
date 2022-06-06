package com.example.dollop.model.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;

import com.example.dollop.model.User;

import static org.apache.http.util.TextUtils.isEmpty;

public class UserDto extends DtoBase<User> {

    private String id;

    private String userName;
    
    private List<ArticleDto> favorites;

    public UserDto() {
    }

    public UserDto(User user) {
        this.id = user.getId().toString();
        this.userName = user.getUserName();
        this.favorites = user.getFavorites()
            .stream().map(a -> new ArticleDto(a))
            .collect(Collectors.toList());
    }

    public String getId() {
        return id;
    }

    public void setId(String _id) {
        this.id = _id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<ArticleDto> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<ArticleDto> favorites) {
        this.favorites = favorites;
    }

    @Override
    public User toModel() {
        return new User(
            new ObjectId(id),
            userName,
            favorites
                .stream().map(a -> a.toModel())
                .collect(Collectors.toList())
        );
    }

    @Override
    public boolean isValidNew() {
        return isEmpty(id) && 
            !isEmpty(userName);
    }
    
}
