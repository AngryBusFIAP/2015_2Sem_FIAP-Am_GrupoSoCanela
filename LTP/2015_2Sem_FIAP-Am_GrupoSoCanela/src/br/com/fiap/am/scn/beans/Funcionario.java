package br.com.fiap.am.scn.beans;

public class Funcionario extends Pessoa {
	
	private int codFuncionario;

	private int cargo;

	private String dtAdmissao;

	private double salario;

	public Funcionario() {
		super();
	}

	public Funcionario(int cargo, String dtAdmissao, double salario) {
		super();
		this.codFuncionario = codFuncionario;
		this.cargo = cargo;
		this.dtAdmissao = dtAdmissao;
		this.salario = salario;
	}

	
	public int getCodFuncionario(){
		return codFuncionario;
	}
	
	public void setCodFuncionario(int codFuncionario){
		this.codFuncionario = codFuncionario;
	}
	
	public int getCargo() {
		return cargo;
	}

	public void setCargo(int cargo) {
		this.cargo = cargo;
	}

	public String getDtAdmissao() {
		return dtAdmissao;
	}

	public void setDtAdmissao(String dtAdmissao) {
		this.dtAdmissao = dtAdmissao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	
}
