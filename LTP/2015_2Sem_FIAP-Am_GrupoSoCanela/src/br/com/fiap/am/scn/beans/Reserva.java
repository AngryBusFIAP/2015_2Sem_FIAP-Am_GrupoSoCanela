package br.com.fiap.am.scn.beans;

public class Reserva {

	private int codReserva;
	
	private String dtSolicitacao;
	
	private String dtInicioReserva;

	private String dtFimReserva;

	private int qtdHospedesCrianca;

	private int qtdHospedesAdulto;

	private Quarto quarto;

	private Double valor;

	private Cliente cliente;
	
	private Funcionario funcionario; 

	private int status;

	public Reserva() {
		super();
	}

	public Reserva(int codReserva, String dtSolicitacao,
			String dtInicioReserva, String dtFimReserva,
			int qtdHospedesCrianca, int qtdHospedesAdulto, Quarto quarto,
			Double valor, Cliente cliente, Funcionario funcionario,
			int status) {
		super();
		this.codReserva = codReserva;
		this.dtSolicitacao = dtSolicitacao;
		this.dtInicioReserva = dtInicioReserva;
		this.dtFimReserva = dtFimReserva;
		this.qtdHospedesCrianca = qtdHospedesCrianca;
		this.qtdHospedesAdulto = qtdHospedesAdulto;
		this.quarto = quarto;
		this.valor = valor;
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.status = status;
	}

	public int getCodReserva() {
		return codReserva;
	}

	public void setCodReserva(int codReserva) {
		this.codReserva = codReserva;
	}

	public String getDtSolicitacao() {
		return dtSolicitacao;
	}

	public void setDtSolicitacao(String dtSolicitacao) {
		this.dtSolicitacao = dtSolicitacao;
	}

	public String getDtInicioReserva() {
		return dtInicioReserva;
	}

	public void setDtInicioReserva(String dtInicioReserva) {
		this.dtInicioReserva = dtInicioReserva;
	}

	public String getDtFimReserva() {
		return dtFimReserva;
	}

	public void setDtFimReserva(String dtFimReserva) {
		this.dtFimReserva = dtFimReserva;
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

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
	