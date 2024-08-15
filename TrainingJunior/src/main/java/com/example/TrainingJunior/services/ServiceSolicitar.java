package com.example.TrainingJunior.services;


import com.example.TrainingJunior.dtos.CadastroSolicitarDto;
import com.example.TrainingJunior.entity.Cliente;
import com.example.TrainingJunior.entity.Produtos;
import com.example.TrainingJunior.entity.Solicitar;
import com.example.TrainingJunior.repository.RepositoryCliente;
import com.example.TrainingJunior.repository.RepositoryProdutos;
import com.example.TrainingJunior.repository.RepositorySolicitar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceSolicitar {

    @Autowired
    private RepositoryProdutos repositoryProdutos;

    @Autowired
    private RepositoryCliente repositoryCliente;

    @Autowired
    private RepositorySolicitar repositorySolicitar;


    public Solicitar cadastroSolicitar(CadastroSolicitarDto dados){
        Produtos produtos = repositoryProdutos.findById(dados.produtosId()).get();
        Cliente cliente = repositoryCliente.findById(dados.clienteId()).get();

        Solicitar solicitar = new Solicitar();
        solicitar.setProdutosId(produtos);
        solicitar.setClienteId(cliente);
        solicitar.setDataSolicitacao(dados.dataSolicitacao());

        return repositorySolicitar.save(solicitar);
    }


}
