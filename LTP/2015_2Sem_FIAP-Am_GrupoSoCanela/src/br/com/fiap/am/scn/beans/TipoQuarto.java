package br.com.fiap.am.scn.beans;
/**
 * Classe Beans para Tipo de Quarto
 */
public class TipoQuarto {
	
	private int codTipoQuarto;
	
	private String descricao;

	private Double valor;

	private String observacao;

	public TipoQuarto() {
		super();
	}

	public TipoQuarto(int codTipoQuarto, String descricao, Double valor, String observacao) {
		super();
		this.codTipoQuarto = codTipoQuarto;
		this.descricao = descricao;
		this.valor = valor;
		this.observacao = observacao;
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

	public String getObservacao(){
		return observacao;
	}

	public void setObservacao(String observacao){
		this.observacao = observacao;
	}
	
	
}
