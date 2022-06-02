package com.example.dollop.service;

import com.example.dollop.model.dto.UserDto;

public interface UserService extends Service<UserDto> {
    UserDto findByName(String name);
}
