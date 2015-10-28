package br.com.fiap.am.scn.beans;

/**
 * Superclasse Beans para Pessoa 
 * Classes que herdam dela sao Cliente/Funcionario
 * 
 * @see br.com.fiap.am.scn.beans.Cliente;
 * @see br.com.fiap.am.scn.beans.Funcionario;
 */
public class Pessoa {

	private int id;

	private String nome;

	public Pessoa() {
		super();
	}

	public Pessoa(int id, String nome, String dtNascimento,
			Long cpf, String rg) {
		super();
		this.id = id;
		this.nome = nome;
			}

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
