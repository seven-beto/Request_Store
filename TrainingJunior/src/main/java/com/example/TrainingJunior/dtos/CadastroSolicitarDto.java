package com.example.TrainingJunior.dtos;

import java.time.LocalDateTime;

public record CadastroSolicitarDto(Long id, Long produtosId, Long clienteId, LocalDateTime dataSolicitacao) {
}
