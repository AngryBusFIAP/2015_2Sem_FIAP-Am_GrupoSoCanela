package br.com.fiap.am.scn.beans;

public class Consumo {

	private int codConsumo;
	
	private int codHospedagem;

	private TipoServico tipoServicos;
	
	private int codPessoa;
	
	private String dtConsumo;
	
	private int qtdeConsumo;

	public Consumo() {
		super();
	}

	public Consumo(int codConsumo, int codHospedagem, TipoServico tipoServicos,
			int codPessoa, String dtConsumo, int qtdeConsumo) {
		super();
		this.codConsumo = codConsumo;
		this.codHospedagem = codHospedagem;
		this.tipoServicos = tipoServicos;
		this.codPessoa = codPessoa;
		this.dtConsumo = dtConsumo;
		this.qtdeConsumo = qtdeConsumo;
	}

	public int getCodConsumo() {
		return codConsumo;
	}

	public void setCodConsumo(int codConsumo) {
		this.codConsumo = codConsumo;
	}

	public int getCodHospedagem() {
		return codHospedagem;
	}

	public void setCodHospedagem(int codHospedagem) {
		this.codHospedagem = codHospedagem;
	}

	public TipoServico getTipoServicos() {
		return tipoServicos;
	}

	public void setTipoServicos(TipoServico tipoServicos) {
		this.tipoServicos = tipoServicos;
	}

	public int getCodPessoa() {
		return codPessoa;
	}

	public void setCodPessoa(int codPessoa) {
		this.codPessoa = codPessoa;
	}

	public String getDtConsumo() {
		return dtConsumo;
	}

	public void setDtConsumo(String dtConsumo) {
		this.dtConsumo = dtConsumo;
	}

	public int getQtdeConsumo() {
		return qtdeConsumo;
	}

	public void setQtdeConsumo(int qtdeConsumo) {
		this.qtdeConsumo = qtdeConsumo;
	}
	
}
