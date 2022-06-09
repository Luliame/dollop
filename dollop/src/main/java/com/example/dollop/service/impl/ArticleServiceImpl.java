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

    /**
     * méthode permettant le listing des articles 
     * @author Guillaume Valentin
     * @see ArticleDto
     * @return une liste d'article 
     * @since 1.0
     */
    @Override
    public List<ArticleDto> findAll() {
        return repo.findAll()
            .stream().map(a -> new ArticleDto(a)).collect(Collectors.toList());
    }

    /**
     * méthode permettant d'obtenir un article par son identifiant  
     * @author Guillaume Valentin
     * @see ArticleDto
     * @param id identifiant de l'article au format chaine de caractère
     * @return l'article désiré 
     * @throws Exception Article non trouvé
     * @since 1.0
     */
    @Override
    public ArticleDto findById(String id) {
        return new ArticleDto(repo.findArticleById(id));
    }

    /**
     * méthode de suppression d'un article paar son identifiant  
     * @author Guillaume Valentin
     * @see ArticleDto
     * @param id identifiant de l'article au format chaine de caractère 
     * @throws Exception Article non trouvé
     * @since 1.0
     */
    @Override
    public void deleteById(String id) {
        repo.deleteById(new ObjectId(id));
    }

    /**
     * méthode de sauvegarde d'un article en base de donnée 
     * @author Guillaume Valentin
     * @see ArticleDto
     * @param article l'article a sauvegarder 
     * @since 1.0
     */
    @Override
    public void save(ArticleDto article) {
        repo.save(article.toModel());
    }

    /**
     * méthode de recherche d'un article par son nom 
     * @author Guillaume Valentin
     * @see ArticleDto
     * @param name nom de l'article a rechercher
     * @return l'article recherché 
     * @since 1.0
     */
    @Override
    public ArticleDto findByName(String name) {
        return new ArticleDto(repo.findArticleByName(name));
    }
}
