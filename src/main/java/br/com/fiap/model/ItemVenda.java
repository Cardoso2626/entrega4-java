package br.com.fiap.model;

public class ItemVenda {
	private long id;
    private int quantidade;
    private double valor;
    
    public ItemVenda() {
        
    }

    public ItemVenda(int quantidade, double valor) {
        super();
        this.quantidade = quantidade;
        this.valor = valor;
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
    

    
    //Método para cadastrar item de venda;
    public void cadastroItemVenda(int qtd, double valor) {
    	setQuantidade(quantidade);
    	setValor(valor);
    }

}
