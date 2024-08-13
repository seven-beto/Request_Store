package com.example.TrainingJunior.services;

import com.example.TrainingJunior.dtos.AtualizarProdutosDto;
import com.example.TrainingJunior.dtos.CadastroProdutosDto;
import com.example.TrainingJunior.entity.Produtos;
import com.example.TrainingJunior.exception.ProdutosException;
import com.example.TrainingJunior.repository.RepositoryProdutos;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    public Produtos findIdProdutos(@PathVariable Long id){
        var find = repositoryProdutos.findById(id);
        if(find.isEmpty()){
            throw new ProdutosException("Produto de id: " + id + " foi encontrado");
        }
        return null;
    }
}
