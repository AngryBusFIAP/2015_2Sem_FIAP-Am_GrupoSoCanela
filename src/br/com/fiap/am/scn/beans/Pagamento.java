package br.com.fiap.am.scn.beans;

public class Pagamento {

	private int codHospedagem;

	private String dtPagamento;

	private FormaPagamento tipo;

	private Double valor;

	public Pagamento() {
		super();
	}

	public Pagamento(int codHospedagem, String dtPagamento,
			FormaPagamento tipo, Double valor) {
		super();
		this.codHospedagem = codHospedagem;
		this.dtPagamento = dtPagamento;
		this.tipo = tipo;
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

	public FormaPagamento getTipo() {
		return tipo;
	}

	public void setTipo(FormaPagamento tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	
}
