package br.com.fiap.am.scn.beans;

public class Pessoa {

	private String nome;

	private Endereco endereco;

	private String dtNascimento;

	private Long cpf;

	private String rg;

	public Pessoa() {
		super();
	}

	public Pessoa(String nome, Endereco endereco, String dtNascimento,
			Long cpf, String rg) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.dtNascimento = dtNascimento;
		this.cpf = cpf;
		this.rg = rg;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public void cadastrarPessoa() {

	}

	public boolean validarCpf() {
		return false;
	}

}
