package com.example.dollop.manager;

import java.util.ArrayList;
import java.util.List;

import com.example.dollop.model.Article;

import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.dollop.gateway.ArticleGateway.*;

@RestController
@RequestMapping("/articles")
public class ArticleManager {
    public ResponseEntity<List<Article>> getArticles(){
        try {
            List<Article> articles = getAllArticle();
            return new ResponseEntity<>(articles,HttpStatus.OK);
        } catch (Exception e) {
            //TODO: handle exception
        }

        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Article> getArticle(@PathVariable("id") String paramId){
        ObjectId id;
        Article article;

        try {
            id = new ObjectId(paramId);
            
            article = getApprovalById(id);

            return new ResponseEntity<>(article,HttpStatus.OK);
        } 
        catch (NumberFormatException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            System.out.println(String.format("ERROR in %s: %s", Thread.currentThread().getStackTrace()[1].getMethodName(), e));
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("")
    @ResponseBody
    public ResponseEntity<Article> postArticle(@RequestBody Article article) {
        try {
            // if (!IsValidNewApproval(article)) //TODO
            //     return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
            
            // computeApproval(article);
            saveApproval(article);
            
            return new ResponseEntity<>(article,HttpStatus.CREATED);
        }
        catch (Exception e) {
            System.out.println(String.format("ERROR in %s: %s", Thread.currentThread().getStackTrace()[1].getMethodName(), e));
        }
        
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Article> putArticle(@RequestBody Article article, @PathVariable("id") String paramId) {
        ObjectId id;
            
        // if (!IsValidNewApproval(article))
        //     return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);

        try {
            id = new ObjectId(paramId);

            if (!ExistApproval(id))
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);


            article.setId(id); // the id from the original object should be null
            
            saveApproval(article);

            return new ResponseEntity<>(article,HttpStatus.OK);
        }
        catch (NumberFormatException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            System.out.println(String.format("ERROR in %s: %s", Thread.currentThread().getStackTrace()[1].getMethodName(), e));
        } 

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Article> deleteArticle(@PathVariable("id") String paramId){
        ObjectId id;
        Article tmpArticle;

        try {
            id = new ObjectId(paramId);
            tmpArticle = getApprovalById(id);

            deleteApprovalById(tmpArticle);
            
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } 
        catch (NumberFormatException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            System.out.println(String.format("ERROR in %s: %s", Thread.currentThread().getStackTrace()[1].getMethodName(), e));
        }
        
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
