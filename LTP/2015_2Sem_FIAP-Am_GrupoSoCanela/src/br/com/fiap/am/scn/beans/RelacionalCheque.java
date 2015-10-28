package br.com.fiap.am.scn.beans;

/**
 * Classe beans para Relacional de Cheque
 * 
 * @see {@link br.com.fiap.am.scn.beans.Hospedagem}
 */
public class RelacionalCheque {
	private int codPgtoCheque;
	private int codHospedagem;
	private int nrCheque;
	private int vlParcela;
	
	public RelacionalCheque() {
		super();
	}

	public RelacionalCheque(int codPgtoCheque, int codHospedagem, int nrCheque,
			int vlParcela) {
		super();
		this.codPgtoCheque = codPgtoCheque;
		this.codHospedagem = codHospedagem;
		this.nrCheque = nrCheque;
		this.vlParcela = vlParcela;
	}

	public int getCodPgtoCheque() {
		return codPgtoCheque;
	}

	public void setCodPgtoCheque(int codPgtoCheque) {
		this.codPgtoCheque = codPgtoCheque;
	}

	public int getCodHospedagem() {
		return codHospedagem;
	}

	public void setCodHospedagem(int codHospedagem) {
		this.codHospedagem = codHospedagem;
	}

	public int getNrCheque() {
		return nrCheque;
	}

	public void setNrCheque(int nrCheque) {
		this.nrCheque = nrCheque;
	}

	public int getVlParcela() {
		return vlParcela;
	}

	public void setVlParcela(int vlParcela) {
		this.vlParcela = vlParcela;
	}
	
}
