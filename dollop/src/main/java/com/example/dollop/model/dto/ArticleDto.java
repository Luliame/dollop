package com.example.dollop.model.dto;

import java.util.List;
import java.util.stream.Collectors;
import static org.apache.http.util.TextUtils.isEmpty;

import com.example.dollop.model.Article;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.bson.types.ObjectId;

public class ArticleDto extends DtoBase<Article> {
    
    private String name;
    private String text;
    
    private float score;

    private List<CommentDto> commentaries;

    public ArticleDto(Article article) {
        this.id = article.getId().toString();
        this.name = article.getName();
        this.text = article.getText();
        this.score = article.getScore();
        this.commentaries = article.getCommentaries()
            .stream().map(c -> new CommentDto(c)).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public List<CommentDto> getCommentaries() {
        return commentaries;
    }

    public void setCommentaries(List<CommentDto> commentaries) {
        this.commentaries = commentaries;
    }
    
    public void addCommentary(CommentDto comment) {
        commentaries.add(comment);
    }

    @Override
    public Article toModel() {
        return new Article(
            new ObjectId(this.id), 
            this.name, 
            this.text, 
            this.score, 
            this.commentaries
                .stream().map(c -> c.toModel()).collect(Collectors.toList())
        );
    }

    @Override
    @JsonIgnore
    public boolean isValidNew() {
        return id == null && 
            !isEmpty(name) &&
            !isEmpty(text);
    }
}
