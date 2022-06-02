package com.example.dollop.manager;

import java.util.ArrayList;
import java.util.List;

import com.example.dollop.model.dto.ArticleDto;
import com.example.dollop.service.impl.ArticleServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/articles")
public class ArticleManager {

    @Autowired
    ArticleServiceImpl serv;

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<ArticleDto>> getArticles(){
        try {
            List<ArticleDto> articles = serv.findAll();
            return new ResponseEntity<>(articles,HttpStatus.OK);
        } catch (Exception e) {
            //TODO: handle exception
        }

        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ArticleDto> getArticle(@PathVariable("id") String paramId){
        
        ArticleDto article;

        try {
            article = serv.findById(paramId);

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
    public ResponseEntity<ArticleDto> postArticle(@RequestBody ArticleDto article) {
        try {
            // if (!IsValidNewApproval(article)) //TODO
            //     return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);

            serv.save(article);
            
            return new ResponseEntity<>(article,HttpStatus.CREATED);
        }
        catch (Exception e) {
            System.out.println(String.format("ERROR in %s: %s", Thread.currentThread().getStackTrace()[1].getMethodName(), e));
        }
        
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ArticleDto> putArticle(@RequestBody ArticleDto article, @PathVariable("id") String paramId) {
        // ObjectId id;
            
        // if (!IsValidNewApproval(article)) //TODO check valid article
        //     return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);

        try {
            // id = new ObjectId(paramId);

            if (serv.findById(paramId) == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);


            article.setId(paramId); // the id from the original object should be null
            
            serv.save(article);

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
    public ResponseEntity<ArticleDto> deleteArticle(@PathVariable("id") String paramId){
        // ObjectId id;
        ArticleDto tmpArticle;

        try {
            //TODO delete
            // id = new ObjectId(paramId);
            // tmpArticle = getArticleById(id);

            // deleteArticleById(tmpArticle);
            
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
