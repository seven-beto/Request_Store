package com.example.TrainingJunior.services;

import com.example.TrainingJunior.dtos.AtualizarCadastroCliente;
import com.example.TrainingJunior.dtos.CadastroClienteDto;
import com.example.TrainingJunior.entity.Cliente;
import com.example.TrainingJunior.repository.RepositoryCliente;
import org.springframework.stereotype.Service;

@Service
public class ServiceCliente {

    private RepositoryCliente repository;

    public Cliente atualizar(AtualizarCadastroCliente dados){
        var update =  repository.getReferenceById(dados.id());
        update.updated(dados);
        return update;
    }
}
