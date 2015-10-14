package br.com.fiap.am.scn.beans;

public class Quarto {

	private int numero;

	private int andar;

	private TipoQuarto tipo;

	private int qtde;

	public Quarto() {
		super();
	}

	public Quarto(int numero, int andar, TipoQuarto tipo, int qtde) {
		super();
		this.numero = numero;
		this.andar = andar;
		this.tipo = tipo;
		this.qtde = qtde;
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

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	
}
