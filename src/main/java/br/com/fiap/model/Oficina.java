package br.com.fiap.model;

import java.util.Scanner;

public class Oficina {
	private long id;
	private String cnpj;
	private String nome;
	private String especialidade;
	private String telefone;
	private String email;
	private Endereco endereco;
	

	public Oficina() {
		
	}
	
	public Oficina(String cnpj, String nome, String especialidade, String telefone, String email, Endereco endereco) {
		super();
		this.cnpj = cnpj;
		this.nome = nome;
		this.especialidade = especialidade;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
	}

	public String getCnpj() {
		return cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
	
	public String toString() {
		return " " + "Cnpj: " + cnpj +"." + " "+ "Nome: " + nome + " " + "Especialidade: " + especialidade + "." + " " + "Telefone: " + telefone + "." + " " + "Email: " + email + "." + " " + "Endereco: " + endereco + ".";
	}
	
	
	//Método de validar a string telefone e setar no objeto criado.
	public void validaTelefoneESetaTelefone() {;
		while (true){
			System.out.println(" ");
			Scanner tec = new Scanner(System.in);
			System.out.println("Digite o seu telefone (não é necessário separar números ou colocar o DD1(código do país), apenas o DDD):");
			String telefone = tec.nextLine();
			if(telefone.length() == 11 ) {
				setTelefone(telefone);	
				break;		
			}
			else {

				System.out.println("O número de telefone digitado é inválido");
			}
		}
	}
	
	//Método para cadastrar oficina, com os sets do objeto.
	public void cadastraOficina(String cnpj, String nome, String especialidade, String email) {;
		setNome(nome);
		setCnpj(cnpj);
		setEspecialidade(especialidade);
		setEmail(email);
	
	}
	
	
	

}
