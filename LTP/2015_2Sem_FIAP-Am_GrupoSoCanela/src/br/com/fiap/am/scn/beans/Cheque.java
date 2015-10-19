package br.com.fiap.am.scn.beans;

public class Cheque {

	private int numeroCheque;

	private String banco;

	private Double valorParcela;

	private int nrParcelas;

	public Cheque() {
		super();
	}

	public Cheque(int numeroCheque, String banco, Double valorParcela,
			int nrParcelas) {
		super();
		this.numeroCheque = numeroCheque;
		this.banco = banco;
		this.valorParcela = valorParcela;
		this.nrParcelas = nrParcelas;
	}

	public int getNumeroCheque() {
		return numeroCheque;
	}

	public void setNumeroCheque(int numeroCheque) {
		this.numeroCheque = numeroCheque;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public Double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(Double valorParcela) {
		this.valorParcela = valorParcela;
	}

	public int getNrParcelas() {
		return nrParcelas;
	}

	public void setNrParcelas(int nrParcelas) {
		this.nrParcelas = nrParcelas;
	}
	
	

}
