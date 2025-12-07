package com.tp4refatorado.model;

import java.util.Objects;

public class Roupa {
    private int id;
    private String nome;
    private String tamanho;
    private double preco;

    public Roupa() {}

    public Roupa(int id, String nome, String tamanho, double preco) {
        this.id = id;
        this.nome = nome;
        this.tamanho = tamanho;
        this.preco = preco;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTamanho() { return tamanho; }
    public void setTamanho(String tamanho) { this.tamanho = tamanho; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Roupa)) return false;
        Roupa roupa = (Roupa) o;
        return id == roupa.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
