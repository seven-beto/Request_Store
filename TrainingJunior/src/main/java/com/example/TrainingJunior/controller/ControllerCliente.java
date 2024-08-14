package com.example.TrainingJunior.controller;


import com.example.TrainingJunior.dtos.AtualizarCadastroCliente;
import com.example.TrainingJunior.dtos.CadastroClienteDto;
import com.example.TrainingJunior.entity.Cliente;
import com.example.TrainingJunior.repository.RepositoryCliente;
import com.example.TrainingJunior.services.ServiceCliente;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ControllerCliente {

    @Autowired
    private RepositoryCliente repository;

    @Autowired
    private ServiceCliente service;

    @GetMapping
    public ResponseEntity allList(){
        var allList = repository.findAll();
        return new ResponseEntity<>(allList, HttpStatus.OK);
    }

    @GetMapping("/nome")
    public List<Cliente> obter(){
       return service.obterNome();
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastro(@RequestBody @Valid CadastroClienteDto dados){
        var cadastro = repository.save(new Cliente(dados));
        return new ResponseEntity<>(cadastro, HttpStatus.CREATED);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody AtualizarCadastroCliente dados){
        var atualizado = service.atualizar(dados);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
