package br.com.fiap.am.scn.beans;

/**
 * Classe Beans para Historico de Valor dos Tipos de Quartos
 * 
 * @see {@link br.com.fiap.am.scn.beans.TipoQuarto}
 */
public class HistoricoValor {
	private int codigoHistValor;
	
	private TipoQuarto tipoQuarto;
	
	private String dt_validade;
	
	private double vl_preco_quarto;

	public HistoricoValor() {
		super();
	}

	public HistoricoValor(int codigoHistValor, TipoQuarto tipoQuarto,
			String dt_validade, double vl_preco_quarto) {
		super();
		this.codigoHistValor = codigoHistValor;
		this.tipoQuarto = tipoQuarto;
		this.dt_validade = dt_validade;
		this.vl_preco_quarto = vl_preco_quarto;
	}

	public int getCodigoHistValor() {
		return codigoHistValor;
	}

	public void setCodigoHistValor(int codigoHistValor) {
		this.codigoHistValor = codigoHistValor;
	}

	public TipoQuarto getTipoQuarto() {
		return tipoQuarto;
	}

	public void setTipoQuarto(TipoQuarto tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}

	public String getDt_validade() {
		return dt_validade;
	}

	public void setDt_validade(String dt_validade) {
		this.dt_validade = dt_validade;
	}

	public double getVl_preco_quarto() {
		return vl_preco_quarto;
	}

	public void setVl_preco_quarto(double vl_preco_quarto) {
		this.vl_preco_quarto = vl_preco_quarto;
	}
	
	
}
