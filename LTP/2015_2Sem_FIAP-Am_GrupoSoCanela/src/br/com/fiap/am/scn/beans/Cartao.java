package br.com.fiap.am.scn.beans;

public class Cartao {
	private int codPagtoCartao;
	// so o codigo ou hospedagem inteira
	private int codHospedagem;
	
	private short qtdeParcelas;

	public Cartao() {
		super();
	}

	public Cartao(int codPagtoCartao, int codHospedagem, short qtdeParcelas) {
		super();
		this.codPagtoCartao = codPagtoCartao;
		this.codHospedagem = codHospedagem;
		this.qtdeParcelas = qtdeParcelas;
	}

	public int getCodPagtoCartao() {
		return codPagtoCartao;
	}

	public void setCodPagtoCartao(int codPagtoCartao) {
		this.codPagtoCartao = codPagtoCartao;
	}

	public int getCodHospedagem() {
		return codHospedagem;
	}

	public void setCodHospedagem(int codHospedagem) {
		this.codHospedagem = codHospedagem;
	}

	public short getQtdeParcelas() {
		return qtdeParcelas;
	}

	public void setQtdeParcelas(short qtdeParcelas) {
		this.qtdeParcelas = qtdeParcelas;
	}
	
}
