package br.com.fiap.util;

import br.com.fiap.model.Oficina;
import br.com.fiap.model.Orcamento;
import br.com.fiap.model.Usuario;

import java.time.LocalDate;

public class OrcamentoTo {

    private long id;
    private Usuario usuario;
    private Oficina oficina;
    private double valorTotal;
    private LocalDate data;



    public Orcamento toOrcamento(){
        Orcamento o = new Orcamento();
        o.setId(id);
        o.setUsuario(usuario);
        o.setOficina(oficina);
        o.setValorTotal(valorTotal);
        o.setData((data));
        return o;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public Usuario getUsuario() {

        return usuario;
    }

    public void setUsuario(Usuario usuario) {

        this.usuario = usuario;
    }

    public Oficina getOficina() {

        return oficina;
    }

    public void setOficina(Oficina oficina) {

        this.oficina = oficina;
    }

    public double getValorTotal() {

        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDate getData() {

        return data;
    }

    public void setData(LocalDate data) {

        this.data = data;
    }
}
