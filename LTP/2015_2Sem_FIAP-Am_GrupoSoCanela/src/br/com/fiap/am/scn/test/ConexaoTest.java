package br.com.fiap.am.scn.test;

import br.com.fiap.am.scn.beans.Cliente;
import br.com.fiap.am.scn.beans.Quarto;
import br.com.fiap.am.scn.exception.Excecao;

import java.util.Calendar;
import java.util.Date;


/**
 * Created by
 *
 * @author vinylimaz
 *         on 19/10/15 & 20:31.
 *         ConexaoTest é uma classe
 */
public class ConexaoTest {

    public static void main(String[] args) throws Excecao {
        Quarto quarto = new Quarto();
        Cliente cliente = new Cliente();
//        Reserva reserva = new Reserva(111, "21/10/2015", "", 1, 1, quarto, 1.0, cliente, "");


        Date date = new Date(System.currentTimeMillis());

        Date dtNow = Calendar.getInstance().getTime();

        System.out.println(date);

        Calendar calendar = Calendar.getInstance();

        System.out.println(calendar);


    }



}
