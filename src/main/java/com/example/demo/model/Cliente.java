package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table (name="cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cod;

    @Column(nullable = false)
    private String nome;

    protected Cliente() {}

    public Cliente(String nome) {
        this.nome = nome;
    }

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
