package br.com.fiap.am.scn.beans;

public class Cheque {

	private int numeroCheque;
	
	private int codHospedagem;
	
	private String banco;

	public Cheque() {
		super();
	}

	public Cheque(int numeroCheque, int codHospedagem, String banco) {
		super();
		this.numeroCheque = numeroCheque;
		this.codHospedagem = codHospedagem;
		this.banco = banco;
	}

	public int getNumeroCheque() {
		return numeroCheque;
	}

	public void setNumeroCheque(int numeroCheque) {
		this.numeroCheque = numeroCheque;
	}

	public int getCodHospedagem(){
		return codHospedagem;
	}
	
	public void setCodHospedagem(int codHospedagem){
		this.codHospedagem = codHospedagem;
	}
	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	

}
