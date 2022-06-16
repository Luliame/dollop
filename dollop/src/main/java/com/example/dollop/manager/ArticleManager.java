package com.example.dollop.manager;

import java.util.List;

import com.example.dollop.model.Article;
import com.example.dollop.model.dto.ArticleDto;
import com.example.dollop.service.impl.ArticleServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
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
public class ArticleManager extends ManagerBase<Article, ArticleDto> {

    @Autowired
    ArticleServiceImpl serv;

    /**
     * méthode de listing des Articles 
     * @author Guillaume Valentin
     * @see ArticleDto
     * @return list des Article sous forme de collection d'objet ArticleDto 
     * @since 1.0
     */
    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<ArticleDto>> getArticles(){
        return getAll(serv);
    }

    /**
     * méthode de récupération d'un article par son id 
     * @author Guillaume Valentin
     * @see ArticleDto
     * @param id id de l'article recherché
     * @return récupère l'article lié à l'id fournie en paramètre de recherche au format articleDto
     * @since 1.0
     */
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ArticleDto> getArticle(@PathVariable("id") String paramId){
        return getById(serv, paramId);
    }

    /**
     * méthode d'ajout d'un articles 
     * @author Guillaume Valentin
     * @see ArticleDto
     * @return récupère l'article qui vient d'etre creer au format articleDto
     * @since 1.0
     */
    @PostMapping("")
    @ResponseBody
    public ResponseEntity<ArticleDto> postArticle(@RequestBody ArticleDto article) {
        return post(serv, article);
    }
    
    /**
     * méthode de mise à jour d'un articles 
     * @author Guillaume Valentin
     * @see ArticleDto
     * @return récupère l'article qui vient d'etre updated au format articleDto
     * @since 1.0
     */
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ArticleDto> putArticle(@RequestBody ArticleDto article, @PathVariable("id") String paramId) {
        return put(serv, article, paramId);
    }

     /**
     * méthode de suppression d'un articles 
     * @author Guillaume Valentin
     * @see ArticleDto
     * @return l'article qui vinet d'etre supprimé au format articleDto
     * @since 1.0
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ArticleDto> deleteArticle(@PathVariable("id") String paramId){
        return deleteById(serv, paramId);
    }
    
}
