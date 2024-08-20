package com.example.TrainingJunior.services;

import com.example.TrainingJunior.dtos.AtualizarProdutosDto;
import com.example.TrainingJunior.dtos.CadastroProdutosDto;
import com.example.TrainingJunior.entity.Produtos;
import com.example.TrainingJunior.exception.MaxProdutosExceptions;
import com.example.TrainingJunior.exception.ProdutosException;
import com.example.TrainingJunior.repository.RepositoryProdutos;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Produtos> obterTipo(){
       return repositoryProdutos.obterTipo();
    }

    public Produtos findIdProdutos(@PathVariable Long id){
        var find = repositoryProdutos.findById(id);
        if(find.isEmpty()){
            throw new ProdutosException();
        }
            return null;
    }

    public Produtos maxProdutos(CadastroProdutosDto dados) throws MaxProdutosExceptions {
        if(repositoryProdutos.count() >= 10){
            throw new MaxProdutosExceptions();
        }
        Produtos produtos = new Produtos(dados);
        produtos.setNome(dados.nome());
        produtos.setTipo(dados.tipo());

        return repositoryProdutos.save(produtos);
    }
}
