package com.example.dollop.manager;

import java.util.List;

import com.example.dollop.model.Article;
import com.example.dollop.model.dto.ArticleDto;
import com.example.dollop.service.impl.ArticleServiceImpl;

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

@RestController
@RequestMapping("/articles")
public class ArticleManager extends ManagerBase<Article, ArticleDto> {

    @Autowired
    ArticleServiceImpl serv;

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<ArticleDto>> getArticles(){
        return getAll(serv);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ArticleDto> getArticle(@PathVariable("id") String paramId){
        return getById(serv, paramId);
    }

    @PostMapping("")
    @ResponseBody
    public ResponseEntity<ArticleDto> postArticle(@RequestBody ArticleDto article) {
        return post(serv, article);
    }
    
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ArticleDto> putArticle(@RequestBody ArticleDto article, @PathVariable("id") String paramId) {
        return put(serv, article, paramId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ArticleDto> deleteArticle(@PathVariable("id") String paramId){
        return deleteById(serv, paramId);
    }
    
}
