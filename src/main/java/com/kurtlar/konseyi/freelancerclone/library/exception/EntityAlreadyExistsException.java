package com.kurtlar.konseyi.freelancerclone.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityAlreadyExistsException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private String fieldValue;


    public EntityAlreadyExistsException(String resourceName , String fieldName , String fieldValue){
        super(String.format("%s already exists with %s : '%s'" , resourceName , fieldName , fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}