package br.com.fiap.am.scn.beans;

public class Reserva {

	private int nroReserva;

	private String dtEntrada;

	private String dtSaida;

	private int qtdHospedesCrianca;

	private int qtdHospedesAdulto;

	private Quarto quarto;

	private Double valor;

	private Cliente cliente;

	private String status;

	public Reserva() {
		super();
	}

	public Reserva(int nroReserva, String dtEntrada, String dtSaida,
			int qtdHospedesCrianca, int qtdHospedesAdulto, Quarto quarto,
			Double valor, Cliente cliente, String status) {
		super();
		this.nroReserva = nroReserva;
		this.dtEntrada = dtEntrada;
		this.dtSaida = dtSaida;
		this.qtdHospedesCrianca = qtdHospedesCrianca;
		this.qtdHospedesAdulto = qtdHospedesAdulto;
		this.quarto = quarto;
		this.valor = valor;
		this.cliente = cliente;
		this.status = status;
	}

	public int getNroReserva() {
		return nroReserva;
	}

	public void setNroReserva(int nroReserva) {
		this.nroReserva = nroReserva;
	}

	public String getDtEntrada() {
		return dtEntrada;
	}

	public void setDtEntrada(String dtEntrada) {
		this.dtEntrada = dtEntrada;
	}

	public String getDtSaida() {
		return dtSaida;
	}

	public void setDtSaida(String dtSaida) {
		this.dtSaida = dtSaida;
	}

	public int getQtdHospedesCrianca() {
		return qtdHospedesCrianca;
	}

	public void setQtdHospedesCrianca(int qtdHospedesCrianca) {
		this.qtdHospedesCrianca = qtdHospedesCrianca;
	}

	public int getQtdHospedesAdulto() {
		return qtdHospedesAdulto;
	}

	public void setQtdHospedesAdulto(int qtdHospedesAdulto) {
		this.qtdHospedesAdulto = qtdHospedesAdulto;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
