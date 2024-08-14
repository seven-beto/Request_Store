package com.example.TrainingJunior.services;

import com.example.TrainingJunior.dtos.AtualizarCadastroCliente;
import com.example.TrainingJunior.dtos.CadastroClienteDto;
import com.example.TrainingJunior.entity.Cliente;
import com.example.TrainingJunior.repository.RepositoryCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCliente {

    @Autowired
    private RepositoryCliente repository;

    public Cliente atualizar(AtualizarCadastroCliente dados){
        var update = repository.getReferenceById(dados.id());
        update.updated(dados);
        return update;
    }

    public List<Cliente> obterNome(){
        return repository.obterNome();
    }
}
