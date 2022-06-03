package com.example.dollop.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.example.dollop.model.dto.CommentDto;
import com.example.dollop.repository.CommentRepository;
import com.example.dollop.service.CommentService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository repo;

    @Override
    public List<CommentDto> findAll() {
        return repo.findAll()
            .stream().map(c -> new CommentDto(c)).collect(Collectors.toList());
    }

    @Override
    public CommentDto findById(String id) {
        return new CommentDto(repo.findCommentById(id));
    }

    @Override
    public void deleteById(String id) {
        repo.deleteById(new ObjectId(id));
    }

    @Override
    public void save(CommentDto comment) {
        repo.save(comment.toModel());
    }
}
