package br.com.fiap.am.scn.beans;

public class Funcionario extends Pessoa {

	private String cargo;

	private String dtAdmissão;

	private double salario;

	public Funcionario() {
		super();
	}

	public Funcionario(String cargo, String dtAdmissão, double salario) {
		super();
		this.cargo = cargo;
		this.dtAdmissão = dtAdmissão;
		this.salario = salario;
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
