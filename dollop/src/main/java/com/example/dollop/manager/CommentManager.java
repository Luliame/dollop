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

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<CommentDto> getArticle(@PathVariable("id") String paramId){
        return getById(serv, paramId);
    }

    @PostMapping("")
    @ResponseBody
    public ResponseEntity<CommentDto> postArticle(@RequestBody CommentDto comment) {
        return post(serv, comment);
    }
    
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<CommentDto> putArticle(@RequestBody CommentDto comment, @PathVariable("id") String paramId) {
        return put(serv, comment, paramId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommentDto> deleteArticle(@PathVariable("id") String paramId){
        return deleteById(serv, paramId);
    }

}
