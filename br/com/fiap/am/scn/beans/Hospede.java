package br.com.fiap.am.scn.beans;

public class Hospede {
	public String[] nomeHospede;
	public String[] tipoHospedagem;
	public int[] qtdeDiaria;
	
	public Hospede() {
		super();
	}

	public Hospede(String[] nomeHospede, String[] tipoHospedagem, 
			int[] qtdeDiaria) {
		super();
		this.nomeHospede = nomeHospede;
		this.tipoHospedagem = tipoHospedagem;
		this.qtdeDiaria = qtdeDiaria;
	}

	public String[] getNomeHospede() {
		return nomeHospede;
	}

	public void setNomeHospede(String[] nomeHospede) {
		this.nomeHospede = nomeHospede;
	}

	public String[] getTipoHospedagem() {
		return tipoHospedagem;
	}

	public void setTipoHospedagem(String[] tipoHospedagem) {
		this.tipoHospedagem = tipoHospedagem;
	}

	public int[] getQtdeDiaria() {
		return qtdeDiaria;
	}

	public void setQtdeDiaria(int[] qtdeDiaria) {
		this.qtdeDiaria = qtdeDiaria;
	}
	
	public double[] CalcularValorEstadia(String[] tipoHospedagem, int[] qtdeDiaria){
		double[] valorEstadia = new double[4];
		
		for(int i = 0; i <=4; i++){
		if(tipoHospedagem[i] == "Single"){
			valorEstadia[i] = 220 * qtdeDiaria[i];
		}else if(tipoHospedagem[i] == "Double"){
			valorEstadia[i] = 270 * qtdeDiaria[i];
		}else if(tipoHospedagem[i] == "Luxo"){
			valorEstadia[i] = 340 * qtdeDiaria[i];
		}else if(tipoHospedagem[i] == "Presidencial"){
			valorEstadia[i] = 450 * qtdeDiaria[i];
		}
	}
		return valorEstadia;
	}
}
