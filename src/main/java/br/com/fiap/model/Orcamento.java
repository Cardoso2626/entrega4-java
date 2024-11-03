package br.com.fiap.model;

import java.time.LocalDate;

public class Orcamento {
	private long id;
	private Usuario usuario;
	private Oficina oficina;
	private double valorTotal;
	private LocalDate data;
	
	public Orcamento() {
		
	}

	public Orcamento(Usuario usuario, Oficina oficina, double valorTotal, LocalDate data) {
		super();
		this.usuario = usuario;
		this.oficina = oficina;
		this.valorTotal = valorTotal;
		this.data = data;
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
