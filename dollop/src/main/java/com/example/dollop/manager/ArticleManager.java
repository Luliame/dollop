package com.example.dollop.manager;

import java.util.ArrayList;
import java.util.List;

import com.example.dollop.model.Article;

import org.bson.types.ObjectId;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        // ObjectId id;
        Article article;

        try {
            // id = Long.parseLong(paramId);
            
            article = getApprovalById(paramId);

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
}
