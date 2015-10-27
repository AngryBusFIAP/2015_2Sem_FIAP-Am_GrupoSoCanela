package br.com.fiap.am.scn.beans;
/**
 * Classe Beans para Reserva
 * 
 * @see br.com.fiap.am.scn.beans.Quarto;
 */
// TODO Verificar se é necessário classe associativa
public class ReservaQuarto {

	private Reserva reserva;
	private Quarto quarto;
	private short qtdePessoaQuarto;
	private String descObservacao;

	public ReservaQuarto() {

	}

	public ReservaQuarto(Reserva reserva, Quarto quarto, short qtdePessoaQuarto, String descObservacao) {
		this.reserva = reserva;
		this.quarto = quarto;
		this.qtdePessoaQuarto = qtdePessoaQuarto;
		this.descObservacao = descObservacao;
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

	public short getQtdePessoaQuarto() {
		return qtdePessoaQuarto;
	}

	public void setQtdePessoaQuarto(short qtdePessoaQuarto) {
		this.qtdePessoaQuarto = qtdePessoaQuarto;
	}

	public String getDescObservacao() {
		return descObservacao;
	}

	public void setDescObservacao(String descObservacao) {
		this.descObservacao = descObservacao;
	}
}
