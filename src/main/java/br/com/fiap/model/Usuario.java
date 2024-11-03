package br.com.fiap.model;

import java.util.Scanner;

public class Usuario {
	private long id;
	private String cpf;
	private String nome;
	private String email;
	private String telefone;
	

	public Usuario() {
		
	}
	
	public Usuario(String cpf, String nome, String email, String telefone) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
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
	
	//Método de validar cpf;
	
	public void validaESetaCpf() {
		while (true) {
			Scanner tec = new Scanner(System.in);
			System.out.println("Digite seu cpf (Não é necessário colocar '.' ou '-'):");
			String cpf = tec.nextLine();
			if(cpf.length() == 11 ) {
				setCpf(cpf);	
				break;		
			}
			else {
				System.out.println("O cpf digitado é inválido!!");
			}
			
		}
	}
	
	//Método de cadastrar usuário;
	public void cadastraUsuario(String nome, String email, String telefone) {
		setNome(nome);
		setEmail(email);
		setTelefone(telefone);

	}
	
	

}
