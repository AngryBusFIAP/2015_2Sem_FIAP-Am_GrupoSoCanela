package br.com.fiap.am.scn.exception;

import java.sql.SQLException;

/**
 * Created by Jardel on 19/10/2015.
 */
public class Excecao extends Exception{

    public Excecao(String m){
        System.out.println("Um problema foi encontrado, contate o suporte");
    }

    public Excecao(){
        System.out.println("Erro inesperado, contate o suporte");
    }

    public Excecao(Exception e){
        if(e.getClass().toString().equals("class java.lang.NumberFormatException")){
            System.out.println("Número informado invalido");
        }
        if(e.getClass().toString().equals("class java.lang.ArithmeticExcpetion")){
            System.out.println("O número não pode ser divido por 0");
        }
        if(e.getClass().toString().equals("class java.lang.NullPointerException")){
            System.out.println("Valor informado inválido");
        }
        if(e.getClass().toString().equals("class java.lang.FileNotFoundException")){
            System.out.println("O arquivo informado não foi encontrado");
        }
        if(e.getClass().toString().equals("class java.lang.ArrayIndexOutofBounds")){
            System.out.println("Valor do array inválido");
        }
        if(e.getClass().toString().equals("class java.lang.IllegalArgumentException")){
            System.out.println("Valor inválido");
        }else{
            System.out.println("Erro inesperado, contate o suporte!");
        }
    }

    public Excecao(SQLException e){
        System.out.println("Erro inesperado com o banco de dados.");
    }

    public Excecao(ClassNotFoundException e) {
        System.out.println("Driver do JDBC não encontrado no projeto");
    }
}
