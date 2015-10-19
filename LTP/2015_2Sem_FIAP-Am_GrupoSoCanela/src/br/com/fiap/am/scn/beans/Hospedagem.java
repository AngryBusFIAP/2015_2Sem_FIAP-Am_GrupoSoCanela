package br.com.fiap.am.scn.beans;

public class Hospedagem {

	private int codHospedagem;

	private Reserva reserva;

	private Funcionario funcionario;

	private String dtHospedagem;

	private String hrHospedagem;

	private Consumo consumo;

	private String dtSaida;

	private Cliente cliente;
	
	public Hospedagem() {
		super();
	}
	
	public Hospedagem(int codHospedagem, Reserva reserva,
			Funcionario funcionario, String dtHospedagem, String hrHospedagem,
			Consumo consumo, String dtSaida, Cliente cliente) {
		super();
		this.codHospedagem = codHospedagem;
		this.reserva = reserva;
		this.funcionario = funcionario;
		this.dtHospedagem = dtHospedagem;
		this.hrHospedagem = hrHospedagem;
		this.consumo = consumo;
		this.dtSaida = dtSaida;
		this.cliente = cliente;
	}

	public int getCodHospedagem() {
		return codHospedagem;
	}

	public void setCodHospedagem(int codHospedagem) {
		this.codHospedagem = codHospedagem;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getDtHospedagem() {
		return dtHospedagem;
	}

	public void setDtHospedagem(String dtHospedagem) {
		this.dtHospedagem = dtHospedagem;
	}

	public String getHrHospedagem() {
		return hrHospedagem;
	}

	public void setHrHospedagem(String hrHospedagem) {
		this.hrHospedagem = hrHospedagem;
	}

	public Consumo getConsumo() {
		return consumo;
	}

	public void setConsumo(Consumo consumo) {
		this.consumo = consumo;
	}

	public String getDtSaida() {
		return dtSaida;
	}

	public void setDtSaida(String dtSaida) {
		this.dtSaida = dtSaida;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String gerarCodigo() {
		return null;
	}

	public boolean validarData() {
		return false;
	}

}
