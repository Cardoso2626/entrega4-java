package br.com.fiap.model;


public class Endereco {
	private long id;
	private String cep;
	private String rua;
	private String cidade;
	private int numero;
	private String estado;
	
	
	
	public Endereco() {
		
	}


	public Endereco(String cep, String rua, String cidade, int numero, String estado, long id) {
		super();
		this.cep = cep;
		this.rua = rua;
		this.cidade = cidade;
		this.numero = numero;
		this.estado = estado;
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
	
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
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
	
	public String toString() {
		return " " + "Cep: " + cep + "." + " " + "Rua: " + rua + "." + " " + "Cidade: " + cidade + "." + " " + "Número: "  + numero + "." + " " +"Estado: " + estado + ".";
	}
	
	
	//Método de captar endereço;
	public void captaEndereco(String cep, String rua, String cidade, int num, String est) {
		setCep(cep);
		setRua(rua);
		setCidade(cidade);
		setNumero(num);
		setEstado(est);
		
	}
}
