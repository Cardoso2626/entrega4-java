package br.com.fiap.util;

import br.com.fiap.model.Usuario;
import br.com.fiap.model.Veiculo;

public class VeiculoTo {
    private long id;
    private String tipo;
    private String modelo;
    private String placa;
    private String montadora;
    private Usuario usuario;
    private int anoFabricacao;

    public Veiculo toVeiculo(){
        Veiculo v = new Veiculo();
        v.setId(id);
        v.setTipo(tipo);
        v.setModelo(modelo);
        v.setPlaca(placa);
        v.setMontadora(montadora);
        v.setUsuario(usuario);
        v.setAnoFabricacao(anoFabricacao);
        return v;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMontadora() {
        return montadora;
    }

    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }
}
