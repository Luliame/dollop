package com.example.dollop.model;

import static com.example.dollop.utils.ListUtil.Average;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("article")
public class Article {

    //#region [ Attributes ]
    private ObjectId id;
    private String name;
    private String text;
    
    private float score = 0;

    private List<Comment> commentaries = new ArrayList<>();
    //#endregion

    //#region [ Constructor ]
    public Article() {
        id = new ObjectId();
    }

    public Article(String name) {
        this();
        this.name = name;
    }

    public Article(String name, String text) {
        this(name);
        this.text = text;
    }
    
    public Article(String name, String text, float score) {
        this.name = name;
        this.text = text;
        this.score = score;
    }

    public Article(ObjectId id, String name, String text, float score, List<Comment> commentaries) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.score = score;
        this.commentaries = commentaries;
    }

    //#endregion

    //#region [ getter / setter ]
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

    public List<Comment> getCommentaries() {
        return commentaries;
    }

    public float getScore() {
        return score;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
    
    //#endregion

    //#region [ Add to list ]
    public void addCommentary(Comment comm){
        commentaries.add(comm);
        score = Average(commentaries
            .stream().map(c -> c.getNote()).collect(Collectors.toList())
        );
    }
    //#endregion
}
