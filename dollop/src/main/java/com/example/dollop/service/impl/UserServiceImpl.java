package com.example.dollop.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import com.example.dollop.model.dto.UserDto;
import com.example.dollop.repository.UserRepository;
import com.example.dollop.service.UserService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repoAuto;
    private static UserRepository repo;

    @PostConstruct
    public void init() {
        UserServiceImpl.repo = repoAuto;
    }

    @Override
    public List<UserDto> findAll() {
        return repo.findAll()
            .stream().map(c -> new UserDto(c)).collect(Collectors.toList());
    }

    @Override
    public UserDto findById(String id) {
        return new UserDto(repo.findUserById(id));
    }

    public static UserDto test(String id) {//TODO a tester !
        return new UserDto(repo.findUserById(id));
    }

    @Override
    public void deleteById(String id) {
        repo.deleteById(new ObjectId(id));
    }

    @Override
    public void save(UserDto user) {
        repo.save(user.toModel());
        
    }

    @Override
    public UserDto findByName(String name) {
        return new UserDto(repo.findUserByName(name));
    }
}
