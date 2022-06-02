package com.example.dollop.manager;

import java.util.ArrayList;
import java.util.List;

import com.example.dollop.model.dto.DtoBase;
import com.example.dollop.service.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class ManagerBase<TDto, T extends DtoBase<TDto>> {

    protected ResponseEntity<List<T>> getAll(Service<T> serv){
        
        try {
            List<T> articles = serv.findAll();
            return new ResponseEntity<>(articles,HttpStatus.OK);
        } 
        catch (Exception e) {
            //TODO: handle exception
        }

        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    protected ResponseEntity<T> getById(Service<T> serv, String paramId) {
        T doc;

        try {
            doc = serv.findById(paramId);

            return new ResponseEntity<>(doc ,HttpStatus.OK);
        } 
        catch (NumberFormatException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            System.out.println(String.format("ERROR in %s: %s", Thread.currentThread().getStackTrace()[1].getMethodName(), e));
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    protected ResponseEntity<T> post(Service<T> serv, T doc) {

        try {
            if (!doc.isValidNew()) 
                return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);

            serv.save(doc);
            
            return new ResponseEntity<>(doc, HttpStatus.CREATED);
        }
        catch (Exception e) {
            System.out.println(String.format("ERROR in %s: %s", Thread.currentThread().getStackTrace()[1].getMethodName(), e));
        }
        
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    protected ResponseEntity<T> put(Service<T> serv, T doc, String paramId){

        if (!doc.isValidNew())
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);

        try {
            if (serv.findById(paramId) == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);


            doc.setId(paramId); // the id from the original object should be null
            
            serv.save(doc);

            return new ResponseEntity<>(doc,HttpStatus.OK);
        }
        catch (NumberFormatException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            System.out.println(String.format("ERROR in %s: %s", Thread.currentThread().getStackTrace()[1].getMethodName(), e));
        } 

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    protected ResponseEntity<T> deleteById(Service<T> serv, String paramId){

        try {
            serv.deleteById(paramId);
            
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
