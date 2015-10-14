package br.com.fiap.am.scn.beans;

public class Servico {

	private TipoServico tipoServico;

	private int qtde;

	private String dtSolicitacao;

	private Double valorTotal;

	public Servico() {
		super();
	}

	public Servico(TipoServico tipoServico, int qtde, String dtSolicitacao,
			Double valorTotal) {
		super();
		this.tipoServico = tipoServico;
		this.qtde = qtde;
		this.dtSolicitacao = dtSolicitacao;
		this.valorTotal = valorTotal;
	}

	public TipoServico getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public String getDtSolicitacao() {
		return dtSolicitacao;
	}

	public void setDtSolicitacao(String dtSolicitacao) {
		this.dtSolicitacao = dtSolicitacao;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	

}
