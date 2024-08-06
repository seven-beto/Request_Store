package com.example.TrainingJunior.services;

import com.example.TrainingJunior.dtos.AtualizarProdutosDto;
import com.example.TrainingJunior.dtos.CadastroProdutosDto;
import com.example.TrainingJunior.entity.Produtos;
import com.example.TrainingJunior.repository.RepositoryProdutos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProdutos {

    @Autowired
    private RepositoryProdutos repositoryProdutos;

    public List<Produtos>findByNome(String nome){
        return repositoryProdutos.findByNome(nome);
    }

    public void atualizarProduto(AtualizarProdutosDto dados){
        var update = repositoryProdutos.getReferenceById(dados.id());
        update.updated(dados);
        return ;
    }

    public CadastroProdutosDto obterTipo(){
        Produtos produtos = repositoryProdutos.obterTipo();
        return new CadastroProdutosDto(produtos.getNome(), produtos.getTipo());
    }

}
