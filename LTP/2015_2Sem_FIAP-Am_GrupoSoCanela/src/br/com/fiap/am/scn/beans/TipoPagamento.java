package br.com.fiap.am.scn.beans;

public class TipoPagamento {
	private short codTipoFormaPag;
	private String desFormaPag;
	
	public TipoPagamento() {
		super();
	}

	public TipoPagamento(short codTipoFormaPag, String desFormaPag) {
		super();
		this.codTipoFormaPag = codTipoFormaPag;
		this.desFormaPag = desFormaPag;
	}

	public short getCodTipoFormaPag() {
		return codTipoFormaPag;
	}

	public void setCodTipoFormaPag(short codTipoFormaPag) {
		this.codTipoFormaPag = codTipoFormaPag;
	}

	public String getDesFormaPag() {
		return desFormaPag;
	}

	public void setDesFormaPag(String desFormaPag) {
		this.desFormaPag = desFormaPag;
	}
	
	
}
