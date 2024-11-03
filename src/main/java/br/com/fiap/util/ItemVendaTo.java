package br.com.fiap.util;

import br.com.fiap.model.ItemVenda;

public class ItemVendaTo {
    private long id;
    private int quantidade;
    private double valor;

    public ItemVenda toItemVenda(){
        ItemVenda i = new ItemVenda();
        i.setId(id);
        i.setQuantidade(quantidade);
        i.setValor(valor);
        return i;
    }


    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public int getQuantidade() {

        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {

        return valor;
    }

    public void setValor(double valor) {

        this.valor = valor;
    }
}
