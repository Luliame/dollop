package com.example.dollop.gateway;

import java.util.List;

import com.example.dollop.model.Article;

import org.bson.types.ObjectId;

public class ArticleGateway {
    public static List<Article> getAllArticle(){
        throw new UnsupportedOperationException("Gateway not implemented.");
    }

    public static Article getApprovalById(ObjectId id){
        throw new UnsupportedOperationException("Gateway not implemented.");
    }

    public static void saveApproval(Article article){
        throw new UnsupportedOperationException("Gateway not implemented.");
    }

    public static boolean ExistApproval(ObjectId id){
        throw new UnsupportedOperationException("Gateway not implemented.");
    }

    public static void deleteApprovalById(Article article){
        throw new UnsupportedOperationException("Gateway not implemented.");
    }
}
