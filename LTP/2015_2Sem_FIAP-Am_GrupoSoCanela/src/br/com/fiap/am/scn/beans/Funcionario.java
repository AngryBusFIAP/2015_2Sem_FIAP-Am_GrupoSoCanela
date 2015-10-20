package br.com.fiap.am.scn.beans;

public class Funcionario extends Pessoa {
	
	private int codFuncionario;

	private String cargo;

	private String dtAdmissão;

	private double salario;

	public Funcionario() {
		super();
	}

	public Funcionario(String cargo, String dtAdmissão, double salario) {
		super();
		this.codFuncionario = codFuncionario;
		this.cargo = cargo;
		this.dtAdmissão = dtAdmissão;
		this.salario = salario;
	}

	
	public int getCodFuncionario(){
		return codFuncionario;
	}
	
	public void setCodFuncionario(int codFuncionario){
		this.codFuncionario = codFuncionario;
	}
	
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDtAdmissão() {
		return dtAdmissão;
	}

	public void setDtAdmissão(String dtAdmissão) {
		this.dtAdmissão = dtAdmissão;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	
}
