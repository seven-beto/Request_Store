package com.example.TrainingJunior.validation;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationErro {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity Erro404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity Erro400(MethodArgumentNotValidException ex){
        var erro = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erro.stream().map(erro400::new).toList());
    }

    public record erro400(String campo, String message){

        public erro400(FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}
