package com.dsbd.project.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "Il campo del nome non può essere vuoto!")
    private String nome;

    @NotNull(message = "Il campo della marca non può essere vuoto!")
    private String marca;

    @NotNull(message = "Il campo del prezzo non può eseere vuoto!")
    private float prezzo;

    @NotNull(message = "Il campo della quantità non può essere vuoto!")
    private int quantita;

    //getter


    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public int getQuantita() {
        return quantita;
    }

    //setter


    public Product setId(int id) {
        this.id = id;
        return this;
    }

    public Product setName(String nome) {
        this.nome = nome;
        return this;
    }

    public Product setMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public Product setPrezzo(float prezzo) {
        this.prezzo = prezzo;
        return this;
    }

    public Product setQuantita(int quantita) {
        this.quantita = quantita;
        return this;
    }

    @Override
    public String toString() {
        return "Product{"+
                "id="+id+
                "brand="+nome+
                "model="+marca+
                "prince="+prezzo+
                "quantity="+quantita+
                "}";
    }
}
