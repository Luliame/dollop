package com.example.dollop.model;

import java.util.List;

import static com.example.dollop.utils.ListUtil.Average;

import org.bson.types.ObjectId;

public class Article {

    //#region [ Attributes ]
    private ObjectId id; //TODO verif type / implémentation
    private String name;
    private String text;
    
    private float score; //TODO utile ou gérer par getter

    private List<Integer> marks;
    private List<String> commentaries;
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

    public List<Integer> getMarks() {
        return marks;//TODO unmodifiable
    }

    public List<String> getCommentaries() {
        return commentaries;//TODO unmodifiable
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
    public void addCommentary(String comm){
        commentaries.add(comm);
    }

    public void addMark(int mark){
        marks.add(mark);
        
        // Calcul du score 
        this.score = Average(marks);//TODO ici ou dans le getter ???
    }
    //#endregion
}
