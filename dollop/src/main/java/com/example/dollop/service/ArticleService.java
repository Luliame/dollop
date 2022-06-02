package com.example.dollop.service;

import com.example.dollop.model.dto.ArticleDto;

public interface ArticleService extends Service<ArticleDto> {
    ArticleDto findByName(String name);
}
