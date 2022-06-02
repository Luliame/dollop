package com.example.dollop.manager;

import static com.example.dollop.gateway.ArticleGateway.*;

import java.util.ArrayList;
import java.util.List;

import com.example.dollop.model.User;

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

@RestController
@RequestMapping("/user")
public class UserManager {
    
    // @author Maxence Desbouys
    // List des Users
    public ResponseEntity<List<User>> getUsers(){
        try {
            // List<User> users = getAllUsers();
            // return new ResponseEntity<>(users,HttpStatus.OK);
        } catch (Exception e) {
            //TODO: handle exception
        }

        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // @author Maxence Desbouys
    // Get user by id 
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<User> getUserById(@PathVariable("id") String paramId){
        ObjectId id;
        User article;

        try {
            id = new ObjectId(paramId);
            // TODO code 

            return new ResponseEntity<User>(new User(),HttpStatus.OK);
        } 
        catch (NumberFormatException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            System.out.println(String.format("ERROR in %s: %s", Thread.currentThread().getStackTrace()[1].getMethodName(), e));
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    // @author Maxence Desbouys
    @PostMapping("")
    @ResponseBody
    public ResponseEntity<User> postArticle(@RequestBody User user) {
        try {
            //TODO
            // Code Post 
            
            return new ResponseEntity<>(user,HttpStatus.CREATED);
        }
        catch (Exception e) {
            System.out.println(String.format("ERROR in %s: %s", Thread.currentThread().getStackTrace()[1].getMethodName(), e));
        }
        
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<User> putUser(@RequestBody User user, @PathVariable("id") String paramId) {
        ObjectId id;
            
        // if (!IsValidNewApproval(article))
        //     return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);

        try {
            id = new ObjectId(paramId);

           // TODO vérification de l'existence en base de la ressource à mettre à jour 
           // TODO méthode d'ajout en base de l'utilisateur 


            return new ResponseEntity<>(new User(),HttpStatus.OK);
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
    public ResponseEntity<User> deleteUser(@PathVariable("id") String paramId){
        ObjectId id;
        User toBeDeleted;

        try {
            id = new ObjectId(paramId);
            // TODO Supression de l'utilisateur par son identifiant
            
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
