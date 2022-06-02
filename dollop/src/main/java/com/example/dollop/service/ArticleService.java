package com.example.dollop.service;

import java.util.List;

import com.example.dollop.model.Article;

public interface ArticleService {
    
    List<Article> findAll();
    Article findByName(String name);

    void save(Article article);
}
