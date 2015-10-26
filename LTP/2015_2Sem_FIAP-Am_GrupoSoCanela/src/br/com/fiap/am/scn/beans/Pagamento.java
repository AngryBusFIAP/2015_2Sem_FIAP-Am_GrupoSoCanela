package br.com.fiap.am.scn.beans;
/**
 * Classe Beans para Pagamento
 *
 * @see br.com.fiap.am.scn.beans.FormaPagamento;
 */
public class Pagamento {

	private int codHospedagem;

	private String dtPagamento;

	private FormaPagamento formaPagamento;

	private double valor;

	public Pagamento() {
		super();
	}

	public Pagamento(int codHospedagem, String dtPagamento,
			FormaPagamento formaPagamento, double valor) {
		super();
		this.codHospedagem = codHospedagem;
		this.dtPagamento = dtPagamento;
		this.formaPagamento = formaPagamento;
		this.valor = valor;
	}

	public int getCodHospedagem() {
		return codHospedagem;
	}

	public void setCodHospedagem(int codHospedagem) {
		this.codHospedagem = codHospedagem;
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
