package br.com.fiap.am.scn.beans;

public class TipoQuarto {

	private String descricao;

	private Double valor;

	public TipoQuarto() {
		super();
	}

	public TipoQuarto(String descricao, Double valor) {
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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
}
