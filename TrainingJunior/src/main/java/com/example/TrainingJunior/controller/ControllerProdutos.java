package com.example.TrainingJunior.controller;


import com.example.TrainingJunior.dtos.AtualizarProdutosDto;
import com.example.TrainingJunior.dtos.CadastroProdutosDto;
import com.example.TrainingJunior.entity.Produtos;
import com.example.TrainingJunior.exception.ProdutosException;
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


    @GetMapping
    public ResponseEntity allList(){
       var allList = repository.findAll();
       return new ResponseEntity<>(allList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity findId(@PathVariable Long id){
        try{
            var find = service.findIdProdutos(id);
           return ResponseEntity.ok().body(repository.findById(id));
        }catch (ProdutosException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/find")
    public ResponseEntity<List<Produtos>>findByNomeProduto(@RequestParam String nome){
        var find = service.findByNome(nome);
        return new ResponseEntity<>(find, HttpStatus.OK);
    }

    @GetMapping("/tipo")
    public List<Produtos> obterTipo(){
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
