package br.com.fiap.am.scn.beans;

/**
 * Classe Beans para Consumo;
 * 
 * @see {@link br.com.fiap.am.scn.beans.TipoServico}
 * @see {@link br.com.fiap.am.scn.beans.Funcionario}
 * @see {@link br.com.fiap.am.scn.beans.Hospedagem}
 */
public class Consumo {

	private int codConsumo;
	
	private Hospedagem hospedagem;

	private TipoServico tipoServicos;
	
	private Funcionario funcionario;
	
	private String dtConsumo;
	
	private int qtdeConsumo;

	private HistoricoPreco historicoPreco;

	public Consumo() {
		super();
	}

	public Consumo(int codConsumo, Hospedagem Hospedagem, TipoServico tipoServicos,
				   Funcionario funcionario, String dtConsumo, int qtdeConsumo, HistoricoPreco historicoPreco) {
		super();
		this.codConsumo = codConsumo;
		this.hospedagem = Hospedagem;
		this.tipoServicos = tipoServicos;
		this.funcionario = funcionario;
		this.dtConsumo = dtConsumo;
		this.qtdeConsumo = qtdeConsumo;
		this.historicoPreco = historicoPreco;
	}

	public int getCodConsumo() {
		return codConsumo;
	}

	public void setCodConsumo(int codConsumo) {
		this.codConsumo = codConsumo;
	}

	public Hospedagem getHospedagem() {
		return hospedagem;
	}

	public void setHospedagem(Hospedagem codHospedagem) {
		this.hospedagem = codHospedagem;
	}

	public TipoServico getTipoServicos() {
		return tipoServicos;
	}

	public void setTipoServicos(TipoServico tipoServicos) {
		this.tipoServicos = tipoServicos;
	}

	public Funcionario getCodFuncionario() {
		return funcionario;
	}

	public void setCodFuncionario(Funcionario codFuncionario) {
		this.funcionario = codFuncionario;
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

	public HistoricoPreco getHistoricoPreco(){
		return historicoPreco;
	}

	public void setHistoricoPreco(HistoricoPreco historicoPreco){
		this.historicoPreco = historicoPreco;
	}

}
