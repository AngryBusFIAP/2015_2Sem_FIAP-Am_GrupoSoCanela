package br.com.fiap.am.scn.teste;

import javax.swing.*;

public class Main {

    static String[] NomeProd = {"Água Mineral", "Cerveja",
            "Vinho", "Whisky Red Label",
            "Suco", "Vodka Absolut"};

    static double[] precoProd = {40.00, 30.00, 15.00, 50.00};

    static String[] nomeServ = {"Cabeleireiro", "Massagem",
            "Lavanderia", "Almoço/Jantar"};

    static double[] precoServ = {5.00, 8.00, 20.00, 25.00,
            7.00, 22.00};

    static int[][] consumoProd = new int[4][6];
    static int[][] consumoServ = new int[4][4];

    public static void main(String[] args) {
        String[] nomeHospede = new String[4];
        String[] tipoHospedagem = new String[4];
        int[] qtdDiaria = new int[4];

        for (int i = 0; i < nomeHospede.length; i++) {
            nomeHospede[i] = JOptionPane.showInputDialog("Digite o nome do hóspede");
            tipoHospedagem[i] = JOptionPane.
                    showInputDialog("Digite o tipo de hospedagem");
            qtdDiaria[i] = Integer.parseInt(JOptionPane.
                    showInputDialog("Digite a quantidade de diárias"));
        }
    }

    public float[] valorEstadia(String[] tipoHospedagem, int[] qtdDiaria){
        float[] total = new float[tipoHospedagem.length];

        for(int i = 0; i < tipoHospedagem.length; i++){

            if(tipoHospedagem[i].equalsIgnoreCase("Single")){
                total[i] = qtdDiaria[i] * 220;
            }else{
                if(tipoHospedagem[i].equalsIgnoreCase("Double")){
                    total[i] = qtdDiaria[i] * 270;
                }else{
                    if(tipoHospedagem[i].equalsIgnoreCase("Luxo")){
                        total[i] = qtdDiaria[i] * 340;
                    }else{
                        if(tipoHospedagem[i].equalsIgnoreCase("Presidencial")){
                            total[i] = qtdDiaria[i] * 450;
                        }
                    }
                }
            }
        }
        return total;
    }


}
	

