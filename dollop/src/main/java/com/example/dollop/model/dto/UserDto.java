package com.example.dollop.model.dto;

import com.example.dollop.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDto extends DtoBase<User> {

    public UserDto(User user) {
        //TODO user construct 
    }

    @Override
    public User toModel() {
        // TODO Auto-generated method stub
        return null;
    }

    @JsonIgnore
    @Override
    public boolean isValidNew() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
