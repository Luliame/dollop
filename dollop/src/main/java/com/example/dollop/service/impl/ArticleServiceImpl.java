package com.example.dollop.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.example.dollop.model.dto.ArticleDto;
import com.example.dollop.repository.ArticleRepository;
import com.example.dollop.service.ArticleService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository repo;
    @Autowired
    private CommentServiceImpl commServ;

    @Override
    public List<ArticleDto> findAll() {
        return repo.findAll()
            .stream().map(a -> new ArticleDto(a)).collect(Collectors.toList());
    }

    @Override
    public ArticleDto findById(String id) {
        return new ArticleDto(repo.findArticleById(id));
    }

    @Override
    public void deleteById(String id) {
        ArticleDto a = findById(id);
        a.getCommentaries().forEach(c -> commServ.deleteById(c.getId()));
        repo.deleteById(new ObjectId(id));
    }

    @Override
    public void save(ArticleDto article) {
        repo.save(article.toModel());
    }

    @Override
    public ArticleDto findByName(String name) {
        return new ArticleDto(repo.findArticleByName(name));
    }
}