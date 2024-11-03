package br.com.fiap.util;

import br.com.fiap.model.Usuario;

public class UsuarioTo {

    private long id;
    private String cpf;
    private String nome;
    private String email;
    private String telefone;


    public Usuario toUsuario(){
        Usuario u = new Usuario();
        u.setId(id);
        u.setCpf(cpf);
        u.setNome(nome);
        u.setEmail(email);
        u.setTelefone(telefone);
        return u;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public String getCpf() {

        return cpf;
    }

    public void setCpf(String cpf) {

        this.cpf = cpf;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getTelefone() {

        return telefone;
    }

    public void setTelefone(String telefone) {

        this.telefone = telefone;
    }
}
