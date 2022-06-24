package com.example.dollop.model.dto;

import static org.apache.http.util.TextUtils.isEmpty;

import java.util.List;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;

import com.example.dollop.model.User;

public class UserDto extends DtoBase<User> {
    
    //#region [ Attributes ]
    private String userName;
    
    private List<ArticleDto> favorites;
    //#endregion

    //#region [ Constructor ]
    public UserDto(User user) {
        this.id = user.getId().toString();
        this.userName = user.getUserName();
        this.favorites = user.getFavorites()
            .stream().map(a -> new ArticleDto(a))
            .collect(Collectors.toList());
    }

    public UserDto(String userName) {
        super();
        this.userName = userName;
    }
    //#endregion

    //#region [ getter / setter ]
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
    //#endregion

    //#region [ Add to list ]
    public void addFavorite(ArticleDto article) {
        favorites.add(article);
    }
    //#endregion

    //#region [ override ]
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
    //#endregion
}
