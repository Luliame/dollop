package com.example.dollop.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dollop.model.Comment;
import com.example.dollop.model.dto.CommentDto;
import com.example.dollop.service.impl.CommentServiceImpl;

@RestController
@RequestMapping("/comments")
public class CommentManager extends ManagerBase<Comment, CommentDto> {

    @Autowired
    CommentServiceImpl serv;

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<CommentDto>> getArticles(){
        return getAll(serv);
    }
    
}
