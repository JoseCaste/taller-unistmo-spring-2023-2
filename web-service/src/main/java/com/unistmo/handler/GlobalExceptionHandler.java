package com.unistmo.handler;

import com.unistmo.exception.ControllerException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public List<Object> requestParamsError(MethodArgumentNotValidException methodArgumentNotValidException){

        List<Object> listError = new ArrayList<>();
        methodArgumentNotValidException.getFieldErrors().forEach(error -> {
            Map<String, Object> responseBody = new HashMap<>();

            responseBody.put("param", error.getField());
            responseBody.put("paramType", error.getRejectedValue());
            responseBody.put("message", error.getDefaultMessage());
            responseBody.put("date", LocalDateTime.now());
            listError.add(responseBody);
        });

        return listError;
    }

    @ExceptionHandler(ControllerException.class)
    public ControllerDetailError controllerError(ControllerException controllerException){
        ControllerDetailError controllerDetailError = new ControllerDetailError();

        controllerDetailError.setDate(LocalDateTime.now());
        controllerDetailError.setMessage(controllerDetailError.getMessage());
        controllerDetailError.setStatusCode(HttpStatus.NOT_FOUND);

        return controllerDetailError;
    }
}
