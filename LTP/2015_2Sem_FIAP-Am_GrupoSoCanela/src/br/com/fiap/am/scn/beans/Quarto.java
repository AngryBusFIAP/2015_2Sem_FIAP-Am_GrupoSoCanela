package br.com.fiap.am.scn.beans;
/**
 * Classe beans para Quarto
 * 
 * @see br.com.fiap.am.scn.beans.TipoQuarto;
 */
public class Quarto {

	private int numero;

	private int andar;

	private TipoQuarto tipo;

	private int capacidade;

	public Quarto() {
		super();
	}

	public Quarto(int numero, int andar, TipoQuarto tipo, int capacidade) {
		super();
		this.numero = numero;
		this.andar = andar;
		this.tipo = tipo;
		this.capacidade = capacidade;
	}

	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAndar() {
		return andar;
	}

	public void setAndar(int andar) {
		this.andar = andar;
	}

	public TipoQuarto getTipo() {
		return tipo;
	}

	public void setTipo(TipoQuarto tipo) {
		this.tipo = tipo;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

}
