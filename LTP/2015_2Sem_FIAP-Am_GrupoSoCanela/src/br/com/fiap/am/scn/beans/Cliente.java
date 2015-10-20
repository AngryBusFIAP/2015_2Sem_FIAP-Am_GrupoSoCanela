package br.com.fiap.am.scn.beans;

public class Cliente extends Pessoa {

	private String dtNascimento;

	private int quartoPreferido;

	private long cpf;

	private String rg;

	private String email;

	private String senha;

	public Cliente() {
		super();
	}

	public Cliente(String dtNascimento, int quartoPreferido, long cpf, String rg, String email, String senha) {
		super();
		this.dtNascimento = dtNascimento;
		this.quartoPreferido = quartoPreferido;
		this.cpf = cpf;
		this.rg = rg;
		this.email = email;
		this.senha = senha;
	}

	public String getDtNascimento(){
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento){
		this.dtNascimento = dtNascimento;
	}

	public int getQuartoPreferido(){
		return quartoPreferido;
	}

	public void setQuartoPreferido(int quartoPreferido){
		this.quartoPreferido = quartoPreferido;
	}

	public long getCpf(){
		return cpf;
	}

	public void setCpf(long cpf){
		this.cpf = cpf;
	}

	public String getRg(){
		return rg;
	}

	public void setRg(String rg){
		this.rg = rg;
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


}
