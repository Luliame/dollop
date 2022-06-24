package com.example.dollop.service;

import java.util.List;

public interface Service <T> {
    List<T> findAll();

    T findById(String id);
    
    void deleteById(String id);

    void save(T article);
}
