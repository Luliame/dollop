package com.example.dollop.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dollop.model.User;
import com.example.dollop.model.dto.UserDto;
import com.example.dollop.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserManager extends ManagerBase<User, UserDto> {

    @Autowired
    UserServiceImpl serv;

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<UserDto>> getArticles(){
        return getAll(serv);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<UserDto> getArticle(@PathVariable("id") String paramId){
        return getById(serv, paramId);
    }

    @PostMapping("")
    @ResponseBody
    public ResponseEntity<UserDto> postArticle(@RequestBody UserDto user) {
        return post(serv, user);
    }
    
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<UserDto> putArticle(@RequestBody UserDto user, @PathVariable("id") String paramId) {
        return put(serv, user, paramId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> deleteArticle(@PathVariable("id") String paramId){
        return deleteById(serv, paramId);
    }
    
}
