package com.example.TrainingJunior.repository;

import com.example.TrainingJunior.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositoryCliente extends JpaRepository<Cliente, Long> {
}
