package com.example.dollop.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.dollop.model.Comment;

public interface CommentRepository extends MongoRepository<Comment, ObjectId> {

    @Query("{id:'?0'}")
    Comment findCommentById(String id);

    List<Comment> findAll();
    
    public long count();
}
