package com.example.TrainingJunior.repository;

import com.example.TrainingJunior.entity.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface RepositoryProdutos extends JpaRepository<Produtos, Long> {

    public List<Produtos> findByNome(String nome);

    @Query(value = "SELECT * FROM produtos WHERE tipo = 'SUPLEMENTO'", nativeQuery = true)
    List<Produtos> obterTipo();
}
