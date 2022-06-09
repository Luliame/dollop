package com.example.dollop.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import com.example.dollop.model.dto.UserDto;
import com.example.dollop.repository.UserRepository;
import com.example.dollop.service.UserService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static UserRepository repoStatic;
    @Autowired
    private UserRepository repo;

    @PostConstruct
    public void init() {
        UserServiceImpl.repoStatic = repo;
    }

    /**
     * méthode permettant d'obtenir tous les utilisateurs en base  
     * @author Guillaume Valentin
     * @see UserDto
     * @return la liste de tous les utilisateurs en base 
     * @since 1.0
     */
    @Override
    public List<UserDto> findAll() {
        return repo.findAll()
            .stream().map(c -> new UserDto(c)).collect(Collectors.toList());
    }

    /**
     * méthode permettant d'obtenir un utilisateur par son identifiant  
     * @author Guillaume Valentin
     * @see UserDto
     * @param id identifiant de l'utilistaeur en BDD au format chaine de caractère
     * @return l'utilisateur recherché
     * @throws Exception utilisateur non trouvé
     * @since 1.0
     */
    @Override
    public UserDto findById(String id) {
        return new UserDto(repo.findUserById(id));
    }

    /**
     * méthode static permettant d'obtenir un utilisateur par son identifiant 
     * @author Guillaume Valentin
     * @see UserDto
     * @param id identifiant de l'utilistaeur en BDD au format chaine de caractère
     * @return l'utilisateur recherché
     * @throws Exception utilisateur non trouvé
     * @since 1.0
     */
    public static UserDto findByIdStatic(String id) {
        return new UserDto(repoStatic.findUserById(id));
    }

    /**
     * méthode permettant de supprimer un utilisateur par son id 
     * @author Guillaume Valentin
     * @see UserDto
     * @param id identifiant de l'utilistaeur en BDD au format chaine de caractère
     * @throws Exception utilisateur non trouvé
     * @since 1.0
     */
    @Override
    public void deleteById(String id) {
        repo.deleteById(new ObjectId(id));
    }

    /**
     * méthode permettant de sauvegarder un utilisateur par son id 
     * @author Guillaume Valentin
     * @see UserDto
     * @param user l'utilisateur a sauvegardé en base
     * @since 1.0
     */
    @Override
    public void save(UserDto user) {
        repo.save(user.toModel());
        
    }

    /**
     * méthode de recherche d'un utilisateur par son nom
     * @author Guillaume Valentin
     * @see UserDto
     * @param name recherche l'utilisteur par son nom
     * @throws Exception utilisateur non trouvé
     * @since 1.0
     */
    @Override
    public UserDto findByName(String name) {
        return new UserDto(repo.findUserByName(name));
    }
}
