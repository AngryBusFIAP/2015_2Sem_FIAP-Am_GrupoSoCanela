package br.com.fiap.am.scn.teste;

import javax.swing.*;

public class Main {

    static String[] nomeProd = {"Água Mineral", "Cerveja", "Vinho", "Whisky Red Label","Suco", "Vodka Absolut"};
    static double[] precoProd = {5.00, 8.00, 20.00, 25.00, 7.00, 22.00};
    static double[] precoServ = {40.00, 30.00, 15.00, 50.00};
    static String[] nomeServ = {"Cabeleireiro", "Massagem","Lavanderia", "Almoço/Jantar"};
    static int[][] consumoProd = new int[4][6];
    static int[][] consumoServ = new int[4][4];

    public static void main(String[] args) {
        System.out.println("==========Sistema=Hotel=Boa=Viagem===========\n|~~Criado pelo grupo: SÓ CANELA na " +
                "canjica~~|\n|\t\t\t\tIntegrantes\t\t\t\t\t|\n|\t\tHenrique Marçulo\tRM: 74329\t\t|\n|\t\t" +
                "Jardel Gomes\t\tRM: 74763\t\t|\n|\t\tVinicius Lima\t\tRM: 75345\t\t|\n|\t\t" +
                "Augusto Ribeiro\t\tRM: 75473\t\t|"+
                "\n=============================================");
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

        double[] totalHospedeEstadia = new double[4];
        totalHospedeEstadia = valorEstadia(tipoHospedagem, qtdDiaria, nomeHospede);
        inserirProd();
        inserirServ();
        gerarRelatorioGerencial(nomeHospede, totalHospedeEstadia);
    }

    //Adcionado a variavel nome dos hospedes, para melhor apresentação dos dados
    public static double[] valorEstadia(String[] tipoHospedagem, int[] qtdDiaria, String[] nomeHospede) {
        double[] total = new double[tipoHospedagem.length];

        for (int i = 0; i < tipoHospedagem.length; i++) {
            //Enquanto o tipo de quarto estiver errado faça
            while (!tipoHospedagem[i].equalsIgnoreCase("Single") && !tipoHospedagem[i].equalsIgnoreCase("Double") && !tipoHospedagem[i].equalsIgnoreCase("Luxo") && !tipoHospedagem[i].equalsIgnoreCase("Presidencial")) {
                System.out.println("Suite invalida para o hospede: "+nomeHospede[i]+"!\nHospedagem digitada: " +
                        tipoHospedagem[i]+"\nSuites permitidas: Single, Double, Luxo, Presidencial");
                tipoHospedagem[i] = JOptionPane.showInputDialog("Digite a suite correta");
            }
            if (tipoHospedagem[i].equalsIgnoreCase("Single")) {
                total[i] = qtdDiaria[i] * 220;
            } else {
                if (tipoHospedagem[i].equalsIgnoreCase("Double")) {
                    total[i] = qtdDiaria[i] * 270;
                } else {
                    if (tipoHospedagem[i].equalsIgnoreCase("Luxo")) {
                        total[i] = qtdDiaria[i] * 340;
                    } else {
                        if (tipoHospedagem[i].equalsIgnoreCase("Presidencial")) {
                            total[i] = qtdDiaria[i] * 450;
                        }
                    }
                }
            }
        }
        return total;
    }

    public static void inserirProd(){
        for (int i = 0; i < consumoProd.length; i++) {
            for (int j = 0; j < consumoProd[i].length; j++) {
                consumoProd[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de " +
                        ""+nomeProd[j]+" consumida pelo hospede 0" + (i+1)));
            }
        }
    }

    public static void inserirServ(){
        for (int i = 0; i < consumoServ.length; i++) {
            for (int j = 0; j < consumoServ[i].length; j++) {
                consumoServ[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de " + nomeServ[j] + " utilizado pelo hospede 0" + (i+1)));
            }
        }
    }

    public static void gerarRelatorioGerencial(String[] nomeHospede, double[] totalHospedeEstadia){
        double[] totalHospedeProd = new double[4];
        double[] totalHospedeServ = new double[4];
        double totalProd = 0, totalServ = 0, totalEstadia = 0, totalGeral = 0;
        for(int i = 0; i < consumoProd.length; i++){
            for(int j = 0; j < consumoProd[i].length; j++){
                totalHospedeProd[i] += consumoProd[i][j] * precoProd[j];
                if(j < 4) {
                    totalHospedeServ[i] += consumoServ[i][j] * precoServ[j];
                }
            }
        }
        double[] totalHospedeGeral = new double[4];
        for(int i = 0; i < totalHospedeGeral.length; i++){
            totalHospedeGeral[i] = (totalHospedeProd[i] + totalHospedeServ[i] + totalHospedeEstadia[i]);
        }

        System.out.println("Relatório Gerencial Hotel Boa Viagem\n\n" +
                "Cliente\t|Total Diarias\tTotal Serviço\tTotal Produto\tTotal Geral");
        for(int i = 0; i < nomeHospede.length; i++) {
            System.out.println(nomeHospede[i]+"\t"+totalHospedeEstadia[i]+"\t"+totalHospedeServ[i]+
                    "\t|"+totalHospedeProd[i]+"\t|" +
                    totalHospedeGeral[i]+"\n");
        }
        System.out.println("Relatorio financeiro\n");
        for(int i = 0; i < totalHospedeGeral.length; i++){
            totalEstadia += totalHospedeEstadia[i];
            totalProd += totalHospedeProd[i];
            totalServ += totalHospedeServ[i];
        }
        totalGeral = (totalEstadia + totalProd + totalServ);

        System.out.println("Total Geral Estadia: "+ totalEstadia+"\nTotal Geral Serviços: "+totalServ+"\nTotal Geral Produtos: "+totalProd+"\nTotal Geral: "+totalGeral);
    }
}
	

