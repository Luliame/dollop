package com.example.dollop.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class DtoBase<T> {
    
    protected String id;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonIgnore
    public abstract boolean isValidNew();

    public abstract T toModel();
}
