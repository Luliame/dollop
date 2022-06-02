package com.example.dollop.service;

import java.util.List;

import com.example.dollop.model.dto.ArticleDto;

public interface ArticleService {
    
    List<ArticleDto> findAll();
    ArticleDto findByName(String name);
    ArticleDto findById(String id);

    void save(ArticleDto article);
}
