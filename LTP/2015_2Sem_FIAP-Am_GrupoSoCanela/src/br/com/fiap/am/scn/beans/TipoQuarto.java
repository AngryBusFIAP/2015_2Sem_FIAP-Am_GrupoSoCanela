package br.com.fiap.am.scn.beans;

public class TipoQuarto {
	
	private int codTipoQuarto;
	
	private String descricao;

	private Double valor;

	public TipoQuarto() {
		super();
	}

	public TipoQuarto(int codTipoQuarto, String descricao, Double valor) {
		super();
		this.codTipoQuarto = codTipoQuarto;
		this.descricao = descricao;
		this.valor = valor;
	}

	
	public int getCodTipoQuarto() {
		return codTipoQuarto;
	}

	public void setCodTipoQuarto(int codTipoQuarto) {
		this.codTipoQuarto = codTipoQuarto;
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
