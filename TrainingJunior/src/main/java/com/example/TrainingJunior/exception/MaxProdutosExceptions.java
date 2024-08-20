package com.example.TrainingJunior.exception;

public class MaxProdutosExceptions extends RuntimeException {

    public MaxProdutosExceptions(){
        super("Limite de produtos cadastrados excedido");
    }

    public MaxProdutosExceptions(String message) {
        super(message);
    }
}
