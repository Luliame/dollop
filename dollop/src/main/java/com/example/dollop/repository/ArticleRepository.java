package com.example.dollop.repository;

import com.example.dollop.model.Article;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ArticleRepository extends MongoRepository<Article, ObjectId> {
    
    @Query("{name:'?0'}")
    Article findItemByName(String name);

    // @Query("{article:'?0'}")
    // Article save(Article article);

    public long count();
}
