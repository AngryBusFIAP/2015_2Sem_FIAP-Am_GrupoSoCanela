package br.com.fiap.am.scn.beans;

public class Cliente extends Pessoa {

	private String email;

	private String senha;

	public Cliente() {
		super();
	}

	public Cliente(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	
	public void alterarSenha() {

	}

}
