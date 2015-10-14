package br.com.fiap.am.scn.beans;

public class CartaoDebito {

	private String bandeira;

	public CartaoDebito() {
		super();
	}

	public CartaoDebito(String bandeira) {
		super();
		this.bandeira = bandeira;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	
}
