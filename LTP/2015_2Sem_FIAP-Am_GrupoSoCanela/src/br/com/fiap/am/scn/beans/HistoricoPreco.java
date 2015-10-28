package br.com.fiap.am.scn.beans;

/**
 * Classe Beans para Historico de Preco dos Servicos/Produtos
 * 
 * @see {@link br.com.fiap.am.scn.beans.TipoServico}
 */
public class HistoricoPreco {
	private int codHistPreco;
	private TipoServico tipoServico;
	private String dtValidade;
	private double vlPreco;

	
	public HistoricoPreco() {
		super();
	}

	public HistoricoPreco(int codHistPreco, TipoServico tipoServico,
			String dtValidade, double vlPreco) {
		super();
		this.codHistPreco = codHistPreco;
		this.tipoServico = tipoServico;
		this.dtValidade = dtValidade;
		this.vlPreco = vlPreco;
	}

	public int getCodHistPreco() {
		return codHistPreco;
	}

	public void setCodHistPreco(int codHistPreco) {
		this.codHistPreco = codHistPreco;
	}

	public TipoServico getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}

	public String getDtValidade() {
		return dtValidade;
	}

	public void setDtValidade(String dtValidade) {
		this.dtValidade = dtValidade;
	}

	public double getVlPreco() {
		return vlPreco;
	}

	public void setVlPreco(double vlPreco) {
		this.vlPreco = vlPreco;
	}
	
	
	
}
