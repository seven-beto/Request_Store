package com.example.TrainingJunior.entity;


import com.example.TrainingJunior.dtos.AtualizarCadastroCliente;
import com.example.TrainingJunior.dtos.CadastroClienteDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "cliente")
@Entity(name = "Cliente")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente(CadastroClienteDto dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.email = dados.email();
    }

    public void updated(AtualizarCadastroCliente dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.cpf() != null){
            this.cpf = dados.cpf();
        }
        if(dados.email() != null){
            this.email = dados.email();
        }
    }
}
