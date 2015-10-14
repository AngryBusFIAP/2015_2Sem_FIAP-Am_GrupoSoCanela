package br.com.fiap.am.scn.beans;

public class Consumo {

	private int codHospedagem;

	private Servico servicos;

	private Produto produto;

	private Double valor;

	public Consumo() {
		super();
	}

	public Consumo(int codHospedagem, Servico servicos, Produto produto,
			Double valor) {
		super();
		this.codHospedagem = codHospedagem;
		this.servicos = servicos;
		this.produto = produto;
		this.valor = valor;
	}

	public int getCodHospedagem() {
		return codHospedagem;
	}

	public void setCodHospedagem(int codHospedagem) {
		this.codHospedagem = codHospedagem;
	}

	public Servico getServicos() {
		return servicos;
	}

	public void setServicos(Servico servicos) {
		this.servicos = servicos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	
}
