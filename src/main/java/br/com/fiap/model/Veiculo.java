package br.com.fiap.model;

public class Veiculo {
	
	private long id;
	private String tipo;
	private String modelo; 
	private String placa;
	private String montadora;
	private Usuario usuario;
	private int anoFabricacao;
	
	public Veiculo() {
		
	}

	public Veiculo(String tipo,String modelo, String placa, String montadora, Usuario usuario, int anoFabricacao) {
		super();
		this.tipo = tipo;
		this.modelo = modelo;
		this.placa = placa;
		this.montadora = montadora;
		this.usuario = usuario;
		this.anoFabricacao = anoFabricacao;
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
	
	
	public String getModelo() {

		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
		

}
