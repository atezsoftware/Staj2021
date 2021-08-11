package com.atez.inventory.manager.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

public interface ErrorCode extends Serializable {

    Integer getCode();

    String getName();
    
    String langKey();

    HttpStatus getHttpStatus();
    

}
