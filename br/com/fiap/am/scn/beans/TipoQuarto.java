package java;

public class TipoQuarto {

	private String descricao;

	private Double valor;

	public TipoQuarto(String descricao, Double valor) {
		this.descricao = descricao;
		this.valor = valor;
	}

	public TipoQuarto() {
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
}
