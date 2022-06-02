package com.example.dollop.model.dto;

public abstract class DtoBase<T> {
    
    protected String id;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract boolean isValidNew();

    public abstract T toModel();
}
