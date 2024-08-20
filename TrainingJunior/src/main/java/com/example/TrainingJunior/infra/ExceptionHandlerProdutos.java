package com.example.TrainingJunior.infra;


import com.example.TrainingJunior.exception.ProdutosException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerProdutos extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProdutosException.class)
    public ResponseEntity<String> produtosException(ProdutosException Exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario nao encontrado");
    }
}
