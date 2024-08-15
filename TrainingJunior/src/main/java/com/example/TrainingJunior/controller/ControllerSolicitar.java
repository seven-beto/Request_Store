package com.example.TrainingJunior.controller;

import com.example.TrainingJunior.dtos.CadastroSolicitarDto;
import com.example.TrainingJunior.repository.RepositorySolicitar;
import com.example.TrainingJunior.services.ServiceSolicitar;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/solicitar")
public class ControllerSolicitar {

    @Autowired
    private ServiceSolicitar serviceSolicitar;

    @Autowired
    private RepositorySolicitar repositorySolicitar;

    @GetMapping
    public ResponseEntity allList(){
        var allList = repositorySolicitar.findAll();
        return new  ResponseEntity<>(allList, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastro(@RequestBody CadastroSolicitarDto dados){
        var cadastrar = serviceSolicitar.cadastroSolicitar(dados);
        return new ResponseEntity<>(cadastrar, HttpStatus.CREATED);
    }

}
