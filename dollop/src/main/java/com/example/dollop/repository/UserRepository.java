package com.example.dollop.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.dollop.model.User;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    
    @Query("{id:'?0'}")
    User findUserById(String id);
    
    @Query("{name:'?0'}")
    User findUserByName(String name);

    List<User> findAll();
    
    public long count();
}
