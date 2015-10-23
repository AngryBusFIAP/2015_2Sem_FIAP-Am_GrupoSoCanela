package br.com.fiap.am.scn.beans;

public class FormaPagamento {

	private int codigo;

	private String descricao;

	private Dinheiro dinheiro;

	private Cheque cheque;

	private Cartao cartao;

	public FormaPagamento() {
		super();
	}

	public FormaPagamento(int codigo, String descricao, Dinheiro dinheiro, Cheque cheque, Cartao cartao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.dinheiro = dinheiro;
		this.cheque = cheque;
		this.cartao = cartao;
	}

	public int getCodigo(){
		return codigo;
	}

	public void setCodigo(int codigo){
		this.codigo = codigo;
	}

	public String getDescricao(){
		return descricao;
	}

	public void setDescricao(String descricao){
		this.descricao = descricao;
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
