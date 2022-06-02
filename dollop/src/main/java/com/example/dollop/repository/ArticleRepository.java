package com.example.dollop.repository;

import java.util.List;

import com.example.dollop.model.Article;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ArticleRepository extends MongoRepository<Article, ObjectId> {
    
    @Query("{name:'?0'}")
    Article findArticleByName(String name);

    // List<Article> findAllArticles();
    List<Article> findAll();

    // @Query("{article:'?0'}")
    // Article save(Article article);

    public long count();
}
