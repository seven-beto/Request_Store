package com.example.TrainingJunior.dtos;

import jakarta.validation.constraints.NotBlank;

public record CadastroProdutosDto(

        Long id,

        @NotBlank(message = "Nome do Produto obrigatorio")
        String nome,

        @NotBlank(message = "Tipo do produto obrigatorio")
        String tipo) {
}
