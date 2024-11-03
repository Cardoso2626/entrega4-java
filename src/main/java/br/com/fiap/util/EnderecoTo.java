package br.com.fiap.util;

import br.com.fiap.model.Endereco;

public class EnderecoTo {
    private long id;
    private String cep;
    private String rua;
    private String cidade;
    private int numero;
    private String estado;



    public Endereco toEndereco(){
        Endereco e = new Endereco();
        e.setId(id);
        e.setCep(cep);
        e.setRua(rua);
        e.setCidade(cidade);
        e.setNumero(numero);
        e.setEstado(estado);
        return e;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
