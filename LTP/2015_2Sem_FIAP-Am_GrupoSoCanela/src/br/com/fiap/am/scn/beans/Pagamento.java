package br.com.fiap.am.scn.beans;
/**
 * Classe Beans para Pagamento
 *
 * @see {@link br.com.fiap.am.scn.beans.FormaPagamento}
 */
public class Pagamento {

	private Hospedagem hospedagem;

	private String dtPagamento;

	private FormaPagamento formaPagamento;

	private double valor;

	public Pagamento() {
		super();
	}

	public Pagamento(Hospedagem ospedagem, String dtPagamento,
			FormaPagamento formaPagamento, double valor) {
		super();
		this.hospedagem = hospedagem;
		this.dtPagamento = dtPagamento;
		this.formaPagamento = formaPagamento;
		this.valor = valor;
	}

	public Hospedagem getCodHospedagem() {
		return hospedagem;
	}

	public void setCodHospedagem(Hospedagem codHospedagem) {
		this.hospedagem = codHospedagem;
	}

	public String getDtPagamento() {
		return dtPagamento;
	}

	public void setDtPagamento(String dtPagamento) {
		this.dtPagamento = dtPagamento;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setTipo(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	
}
