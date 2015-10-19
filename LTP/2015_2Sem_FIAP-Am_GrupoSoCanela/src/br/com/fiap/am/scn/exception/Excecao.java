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
            System.out.println("N�mero informado invalido");
        }
        if(e.getClass().toString().equals("class java.lang.ArithmeticExcpetion")){
            System.out.println("O n�mero n�o pode ser divido por 0");
        }
        if(e.getClass().toString().equals("class java.lang.NullPointerException")){
            System.out.println("Valor informado inv�lido");
        }
        if(e.getClass().toString().equals("class java.lang.FileNotFoundException")){
            System.out.println("O arquivo informado n�o foi encontrado");
        }
        if(e.getClass().toString().equals("class java.lang.ArrayIndexOutofBounds")){
            System.out.println("Valor do array inv�lido");
        }
        if(e.getClass().toString().equals("class java.lang.IllegalArgumentException")){
            System.out.println("Valor inv�lido");
        }else{
            System.out.println("Erro inesperado, contate o suporte!");
        }
    }

    public Excecao(SQLException e){
        System.out.println("Erro inesperado com o banco de dados.");
    }

    public Excecao(ClassNotFoundException e) {
        System.out.println("Driver do JDBC n�o encontrado no projeto");
    }
}
