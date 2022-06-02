package com.example.dollop.service.impl;

import java.util.List;

import com.example.dollop.model.Article;
import com.example.dollop.repository.ArticleRepository;
import com.example.dollop.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository repo;

    @Override
    public List<Article> findAll() {
        // return null;
        return repo.findAll();
    }

    @Override
    public void save(Article article) {
        repo.save(article);
    }

    @Override
    public Article findByName(String name) {
        return repo.findArticleByName(name);
    }
    
}
