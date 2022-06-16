package com.example.dollop.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dollop.model.dto.CommentDto;
import com.example.dollop.repository.CommentRepository;
import com.example.dollop.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository repo;


      /**
     * méthode permettant d'obtenir la liste de tous les commentaires
     * @author Guillaume Valentin
     * @see CommentDto
     * @return la liste de tout les commentaires 
     * @since 1.0
     */
    @Override
    public List<CommentDto> findAll() {
        return repo.findAll()
            .stream().map(c -> new CommentDto(c)).collect(Collectors.toList());
    }

    /**
     * méthode permettant d'obtenir un commentaire par son identifiant  
     * @author Guillaume Valentin
     * @see CommentDto
     * @param id identifiant du commentaire en BDD au format chaine de caractère
     * @return le commentaire recherché
     * @throws Exception Commentaire non trouvé
     * @since 1.0
     */
    @Override
    public CommentDto findById(String id) {
        return new CommentDto(repo.findCommentById(id));
    }

     /**
     * méthode permettant de supprimer un commentaire  
     * @author Guillaume Valentin
     * @see CommentDto
     * @param id identifiant du commentaire en BDD au format chaine de caractère
     * @throws Exception Commentaire non trouvé
     * @since 1.0
     */
    @Override
    public void deleteById(String id) {
        repo.deleteById(new ObjectId(id));
    }

    /**
     * méthode permettant de sauvegarder un commentaire  
     * @author Guillaume Valentin
     * @see CommentDto
     * @param comment le commentaire a sauvegarder
     * @since 1.0
     */
    @Override
    public void save(CommentDto comment) {
        repo.save(comment.toModel());
    }
}
