package com.kurtlar.konseyi.freelancerclone.library.enums;

public enum MessageCodes {
    SUCCESS("200", "Success"),
    FAIL("500", "Fail"),
    BAD_REQUEST("400" , "Bad Request"),
    ENTITY_NOT_FOUND("404" , "Entity Not Found")    ,
    ENTITY_ALREADY_EXISTS("409" ,"Entity already exist");

    private final String code;

    private final String message;

    MessageCodes(String code , String message){
        this.code = code;
        this.message = message;
    }

    public String getCode(){
        return this.code;
    }

    public String getMessage(){
        return this.message;
    }
}
