package br.com.fiap.am.scn.beans;
/**
 * Classe Beans para Hospedagem
 * 
 * @see br.com.fiap.am.scn.beans.Consumo;
 * @see br.com.fiap.am.scn.beans.Cliente;
 * @see br.com.fiap.am.scn.beans.Funcionario;
 * @see br.com.fiap.am.scn.beans.Reserva;
 * @see br.com.fiap.am.scn.beans.Quarto;
 */
public class Hospedagem {

	private int codHospedagem;

	private String dtHospedagem;

	private String dtEntrada;
	
	private String dtSaida;
	
	private double percDesconto;

	private Consumo consumo;

	private Cliente cliente;

	private Reserva reserva;
	
	private Quarto quarto;

	private Funcionario funcionario;
	
	public Hospedagem() {
		super();
	}
	
	public Hospedagem(int codHospedagem, String dtHospedagem,
			 String dtEntrada, String dtSaida,
			double percDesconto, Consumo consumo, Cliente cliente,
			Reserva reserva, Quarto quarto, Funcionario funcionario) {
		super();
		this.codHospedagem = codHospedagem;
		this.dtHospedagem = dtHospedagem;
		this.dtEntrada = dtEntrada;
		this.dtSaida = dtSaida;
		this.percDesconto = percDesconto;
		this.consumo = consumo;
		this.cliente = cliente;
		this.reserva = reserva;
		this.quarto = quarto;
		this.funcionario = funcionario;
	}

	

	public int getCodHospedagem() {
		return codHospedagem;
	}

	public void setCodHospedagem(int codHospedagem) {
		this.codHospedagem = codHospedagem;
	}

	public String getDtHospedagem() {
		return dtHospedagem;
	}

	public void setDtHospedagem(String dtHospedagem) {
		this.dtHospedagem = dtHospedagem;
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

	public double getPercDesconto() {
		return percDesconto;
	}

	public void setPercDesconto(double percDesconto) {
		this.percDesconto = percDesconto;
	}

	public Consumo getConsumo() {
		return consumo;
	}

	public void setConsumo(Consumo consumo) {
		this.consumo = consumo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String gerarCodigo() {
		return null;
	}

	public boolean validarData() {
		return false;
	}

}
