package com.scaler.productservicefeb25.controlleradvices;

import com.scaler.productservicefeb25.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException exception)
    {
        return new ResponseEntity<>(//"Product with given id doesnt exist",
                exception.getMessage(),
                HttpStatus.BAD_GATEWAY);
    }
//    @ExceptionHandler(Exception.class)
//    public  void  handleArrayIndexOutOfBound()
//    {
//
//    }
//    @ExceptionHandler(Exception.class)
//    public void handleException()
//    {
//
//    }
}
