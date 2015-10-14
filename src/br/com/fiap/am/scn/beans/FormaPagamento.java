package br.com.fiap.am.scn.beans;

public class FormaPagamento {

	private CartaoCredito credito;

	private Dinheiro dinheiro;

	private Cheque cheque;

	private CartaoDebito debito;

	public FormaPagamento() {
		super();
	}

	public FormaPagamento(CartaoCredito credito, Dinheiro dinheiro,
			Cheque cheque, CartaoDebito debito) {
		super();
		this.credito = credito;
		this.dinheiro = dinheiro;
		this.cheque = cheque;
		this.debito = debito;
	}

	public CartaoCredito getCredito() {
		return credito;
	}

	public void setCredito(CartaoCredito credito) {
		this.credito = credito;
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

	public CartaoDebito getDebito() {
		return debito;
	}

	public void setDebito(CartaoDebito debito) {
		this.debito = debito;
	}

}
