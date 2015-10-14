package br.com.fiap.alg;

import javax.swing.JOptionPane;

public class AlgMain {
	static String[] NomeServ = {"Água Mineral", "Cerveja", 
								"Vinho", "Whisky Red Label",
								"Suco", "Vodka Absolut"};

	static double[] precoProd = {40.00, 30.00, 15.00, 50.00};
	
	static String[] nomeServ = {"Cabeleireiro", "Massagem", 
								"Lavanderia", "Almoço/Jantar"};
	
	static double[] precoServ = {5.00, 8.00, 20.00, 25.00, 
									7.00, 22.00};
	
	static int[][] consumoProd = new int[3][5];
	static int[][] consumoServ = new int[3][3];
	
	public static void main(String[] args) {
		Hospede hospede = new Hospede();
		
		for(int i = 0; i <= 4; i++){
		hospede.nomeHospede[i]= JOptionPane.
			showInputDialog("Digite o nome do hóspede");
		hospede.tipoHospedagem[i] = JOptionPane.
			showInputDialog("Digite o tipo da reserva");
		hospede.qtdeDiaria[i] = JOptionPane.
			showInputDialog("Digite a quantidade de diárias");
		}
		

	}
	
}
