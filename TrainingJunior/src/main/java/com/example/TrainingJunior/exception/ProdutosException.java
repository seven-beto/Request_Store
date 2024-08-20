package com.example.TrainingJunior.exception;

public class ProdutosException extends RuntimeException {

    public ProdutosException(){
        super("Usuario nao encontrado");
    }

    public ProdutosException(String message) {
        super(message);
    }
}
