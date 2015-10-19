package br.com.fiap.am.scn.beans;

public class CartaoCredito {

	private String bandeira;
	private int nrParcelas;
	
	public CartaoCredito(){
		super();
	}

	public CartaoCredito(String bandeira, int nrParcelas) {
		super();
		this.bandeira = bandeira;
		this.nrParcelas = nrParcelas;
	}

	
	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public int getNrParcelas() {
		return nrParcelas;
	}

	public void setNrParcelas(int nrParcelas) {
		this.nrParcelas = nrParcelas;
	}

}
