package br.com.fiap.am.scn.beans;

/**
 * Classe Beans para Tipo de Pagamento
 */
public class TipoPagamento {
	private int codTipoFormaPag;
	private String desFormaPag;
	
	public TipoPagamento() {
		super();
	}

	public TipoPagamento(int codTipoFormaPag, String desFormaPag) {
		super();
		this.codTipoFormaPag = codTipoFormaPag;
		this.desFormaPag = desFormaPag;
	}

	public int getCodTipoFormaPag() {
		return codTipoFormaPag;
	}

	public void setCodTipoFormaPag(int codTipoFormaPag) {
		this.codTipoFormaPag = codTipoFormaPag;
	}

	public String getDesFormaPag() {
		return desFormaPag;
	}

	public void setDesFormaPag(String desFormaPag) {
		this.desFormaPag = desFormaPag;
	}
	
	
}
