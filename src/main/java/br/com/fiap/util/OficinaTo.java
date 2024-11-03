package br.com.fiap.util;

import br.com.fiap.model.Endereco;
import br.com.fiap.model.Oficina;

public class OficinaTo {
    private long id;
    private String cnpj;
    private String nome;
    private String especialidade;
    private String telefone;
    private String email;
    private Endereco endereco;


    public Oficina toOficina(){
        Oficina of = new Oficina();
        of.setId(id);
        of.setCnpj(cnpj);
        of.setNome(nome);
        of.setEspecialidade(especialidade);
        of.setTelefone(telefone);
        of.setEmail(email);
        of.setEndereco(endereco);
        return of;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
