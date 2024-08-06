package com.example.TrainingJunior.controller;


import com.example.TrainingJunior.dtos.AtualizarProdutosDto;
import com.example.TrainingJunior.dtos.CadastroProdutosDto;
import com.example.TrainingJunior.entity.Produtos;
import com.example.TrainingJunior.repository.RepositoryProdutos;
import com.example.TrainingJunior.services.EmailService;
import com.example.TrainingJunior.services.ServiceProdutos;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ControllerProdutos {

    @Autowired
    private RepositoryProdutos repository;

    @Autowired
    private ServiceProdutos service;

    @Autowired
    private EmailService emailService;

    @GetMapping
    public ResponseEntity allList(){
       var allList = repository.findAll();
       return new ResponseEntity<>(allList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity findId(@PathVariable Long id){
        var findForId = repository.findById(id);
        if(findForId.isPresent()){
            return new ResponseEntity<>(findForId, HttpStatus.OK);
        }else{
            String produtoNaoEncontrado = "Produto de id: " + id + " nao encontrado";
            return new ResponseEntity<>(produtoNaoEncontrado, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find")
    public ResponseEntity<List<Produtos>>findByNomeProduto(@RequestParam String nome){
        var find = service.findByNome(nome);
        return new ResponseEntity<>(find, HttpStatus.OK);
    }

    @GetMapping("/tipo")
    public CadastroProdutosDto obterTipo(){
        return service.obterTipo();
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastro(@RequestBody @Valid CadastroProdutosDto dados){
        var cadastro = repository.save(new Produtos(dados));
        return new ResponseEntity<>(cadastro, HttpStatus.CREATED);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody AtualizarProdutosDto dados){
        service.atualizarProduto(dados);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
