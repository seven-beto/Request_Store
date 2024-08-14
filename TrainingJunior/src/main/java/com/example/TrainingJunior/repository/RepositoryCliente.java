package com.example.TrainingJunior.repository;

import com.example.TrainingJunior.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface RepositoryCliente extends JpaRepository<Cliente, Long> {

    @Query(value = "SELECT * FROM cliente WHERE nome LIKE '%H%'", nativeQuery = true)
    List<Cliente> obterNome();

}
