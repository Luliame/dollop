package com.example.dollop.gateway;

import java.util.List;

import com.example.dollop.model.Article;
import com.example.dollop.repository.ArticleRepository;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

public class ArticleGateway {

    @Autowired
    static ArticleRepository articleRepository;

    // @Autowired
    // static SimpleMongoRepository<Article, ObjectId> articleRepository;

    public static List<Article> getAllArticle(){
        throw new UnsupportedOperationException("Gateway not implemented.");
    }

    public static Article getArticleById(ObjectId id){
        throw new UnsupportedOperationException("Gateway not implemented.");
    }

    public static void saveArticle(Article article){
        articleRepository.save(article);
        // throw new UnsupportedOperationException("Gateway not implemented.");
    }

    public static boolean ExistArticle(ObjectId id){
        throw new UnsupportedOperationException("Gateway not implemented.");
    }

    public static void deleteArticleById(Article article){
        throw new UnsupportedOperationException("Gateway not implemented.");
    }
}
