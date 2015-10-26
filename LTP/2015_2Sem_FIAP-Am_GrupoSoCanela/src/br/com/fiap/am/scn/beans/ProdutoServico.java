package br.com.fiap.am.scn.beans;
/**
 * Classe Beans para Produto/Servico
 *  
 * @see br.com.fiap.am.scn.beans.TipoServico;
 */
public class ProdutoServico {
	private TipoServico tipoServico;
	private int codHospedagem;
	private int nr_tipo;
	
	public ProdutoServico() {
		super();
	}

	public ProdutoServico(TipoServico tipoServico, int codHospedagem,
			int nr_tipo) {
		super();
		this.tipoServico = tipoServico;
		this.codHospedagem = codHospedagem;
		this.nr_tipo = nr_tipo;
	}

	public TipoServico getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}

	public int getCodHospedagem() {
		return codHospedagem;
	}

	public void setCodHospedagem(int codHospedagem) {
		this.codHospedagem = codHospedagem;
	}

	public int getNr_tipo() {
		return nr_tipo;
	}

	public void setNr_tipo(int nr_tipo) {
		this.nr_tipo = nr_tipo;
	}
	
}
