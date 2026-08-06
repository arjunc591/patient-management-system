package com.pms.serviceApplication.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidException(MethodArgumentNotValidException ex){
        Map<String,String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error->errorMap.put(error.getField(),error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errorMap);

    }

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<Map<String,String>> emailAlreadyExistException(EmailAlreadyExistException ex){
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("Email Already Exists",ex.getMessage());
        return ResponseEntity.badRequest().body(errorMap);
    }

    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<Map<String,String>> patientAlreadyExists(PatientNotFoundException ex){
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("patient exists",ex.getMessage());
        return ResponseEntity.badRequest().body(errorMap);
    }
}
