package com.unistmo.exception;

import lombok.Data;

@Data
public class ControllerException extends RuntimeException{
    private String message;

    public ControllerException(String message) {
        super(message);
        this.message = message;
    }

    public ControllerException(){
        super();
    }
}
