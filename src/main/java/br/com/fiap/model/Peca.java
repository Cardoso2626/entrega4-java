package br.com.fiap.model;

public class Peca {
	private long id;
	private String nome;
	private String marca;
	private String categoria;
	
	
	public Peca () {
		
	}


	public Peca(int id, String nome, String marca, String categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.categoria = categoria;
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
	
	
	public String toString() {
		return " " + "Id da peça: " + id + "." + " " + "Nome: " + nome + "." + " " + "Marca: " + marca + "." + " " + "Categoria: " + categoria; 
	}
	
	

}
