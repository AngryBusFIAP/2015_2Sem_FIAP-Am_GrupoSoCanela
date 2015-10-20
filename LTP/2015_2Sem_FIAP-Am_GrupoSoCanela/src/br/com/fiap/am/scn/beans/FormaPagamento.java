package br.com.fiap.am.scn.beans;

public class FormaPagamento {

	private Dinheiro dinheiro;

	private Cheque cheque;

	private Cartao cartao;

	public FormaPagamento() {
		super();
	}

	public FormaPagamento(Dinheiro dinheiro, Cheque cheque, Cartao cartao) {
		super();
		this.dinheiro = dinheiro;
		this.cheque = cheque;
		this.cartao = cartao;
	}

	public Dinheiro getDinheiro() {
		return dinheiro;
	}

	public void setDinheiro(Dinheiro dinheiro) {
		this.dinheiro = dinheiro;
	}

	public Cheque getCheque() {
		return cheque;
	}

	public void setCheque(Cheque cheque) {
		this.cheque = cheque;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	
}
