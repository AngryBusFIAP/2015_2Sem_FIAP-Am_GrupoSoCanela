package br.com.fiap.am.scn.beans;

public class Produto {

	private int descricao;

	private int qtde;

	private Double valor;

	private Double valorTotal;

	public Produto() {
		super();
	}

	public Produto(int descricao, int qtde, Double valor, Double valorTotal) {
		super();
		this.descricao = descricao;
		this.qtde = qtde;
		this.valor = valor;
		this.valorTotal = valorTotal;
	}

	public int getDescricao() {
		return descricao;
	}

	public void setDescricao(int descricao) {
		this.descricao = descricao;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
}
