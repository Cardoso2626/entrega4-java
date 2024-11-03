package br.com.fiap.util;

import br.com.fiap.model.Peca;

public class PecaTo {
    private long id;
    private String nome;
    private String marca;
    private String categoria;


    public Peca toPeca(){
        Peca p = new Peca();
        p.setId(id);
        p.setNome(nome);
        p.setMarca(marca);
        p.setCategoria(categoria);
        return p;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getMarca() {

        return marca;
    }

    public void setMarca(String marca) {

        this.marca = marca;
    }

    public String getCategoria() {

        return categoria;
    }

    public void setCategoria(String categoria) {

        this.categoria = categoria;
    }
}
