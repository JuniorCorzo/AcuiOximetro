package com.empresa.dam.apiacuioximetro.controller;

import com.empresa.dam.apiacuioximetro.exceptions.DataNotFoundById;
import com.empresa.dam.apiacuioximetro.exceptions.UserNotExist;
import com.empresa.dam.apiacuioximetro.exceptions.json.ExceptionInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerController {
    @ExceptionHandler(DataNotFoundById.class)
    public ResponseEntity<ExceptionInfo> exceptionInfoResponseEntity(DataNotFoundById e){
        ExceptionInfo exceptionInfo = new ExceptionInfo(e.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exceptionInfo, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotExist.class)
    public ResponseEntity<ExceptionInfo> exceptionInfoResponseEntity(UserNotExist e){
        ExceptionInfo exceptionInfo = new ExceptionInfo(e.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exceptionInfo, HttpStatus.NOT_FOUND);
    }
}
