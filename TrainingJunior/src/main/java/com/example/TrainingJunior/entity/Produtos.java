package com.example.TrainingJunior.entity;


import com.example.TrainingJunior.dtos.AtualizarProdutosDto;
import com.example.TrainingJunior.dtos.CadastroProdutosDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name = "produtos")
@Entity(name = "Produtos")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String tipo;

    @OneToOne(mappedBy = "produtosId")
    private Solicitar solicitar;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Produtos(CadastroProdutosDto dados) {
        this.nome = dados.nome();
        this.tipo = dados.tipo();
    }

    public void updated(AtualizarProdutosDto dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }

        if(dados.tipo() != null){
            this.tipo = dados.tipo();
        }
    }
}
