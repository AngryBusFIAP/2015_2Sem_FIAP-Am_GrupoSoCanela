package br.com.fiap.am.scn.beans;

public class TipoServico {

	private String descricao;

	private double valor;

	public TipoServico() {
		super();
	}

	public TipoServico(String descricao, double valor) {
		super();
		this.descricao = descricao;
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
