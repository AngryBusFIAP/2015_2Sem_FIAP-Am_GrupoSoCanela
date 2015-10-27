package br.com.fiap.am.scn.test;

import br.com.fiap.am.scn.beans.*;
import br.com.fiap.am.scn.bo.HospedagemBO;
import br.com.fiap.am.scn.dao.*;
import br.com.fiap.am.scn.exception.Excecao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Jardel on 22/10/2015.
 */
public class TesteHospedagemDAO {

    public static void main(String[] args) throws Excecao {

        Hospedagem h = new Hospedagem();
        Funcionario f = new Funcionario();
        Cliente c = new Cliente();
        Reserva r = new Reserva();
        Quarto q = new Quarto();
        HospedagemDAO hDAO = new HospedagemDAO();
        ClienteDAO cDAO = new ClienteDAO();
        QuartoDAO qDAO = new QuartoDAO();
        FuncionarioDAO fDAO = new FuncionarioDAO();
        ReservaDAO rDAO = new ReservaDAO();

        SimpleDateFormat dateFormat = new SimpleDateFormat();
        try {

            System.out.println(new HospedagemBO().verifDtEntrada(1));
            Calendar hoje = Calendar.getInstance();
            Calendar dtReserva = Calendar.getInstance();



        } catch (ParseException e) {
            throw new Excecao(e);
        }

//        q = qDAO.getQuarto(1);
//        h.setQuarto(q);
//
//        r = rDAO. getReserva(1);
//        h.setReserva(r);
//
//        c = cDAO.getCliente(1);
//        h.setCliente(c);
//
//        f = fDAO.getFuncionario(8);
//        h.setFuncionario(f);
//
//        h.setDtEntrada("22/10/2015");
//        h.setDtSaida("25/10/2015");
//        h.setPercDesconto(5);
//
//        HospedagemBO hBO = new HospedagemBO();
//
//        try {
//            System.out.println(new HospedagemBO().verifDtEntrada(1));
//        } catch (ParseException e) {
//            throw new Excecao(e);
//
//        }


        //h.setQuarto(q.setNumero(1));

//        h = hDAO.getHospedagem(9);
//        System.out.println(h.getCodHospedagem() + "\n" + h.getQuarto().getNumero() + "\n" + h.getReserva().getCodReserva() + "\n" +
//        h.getCliente().getId() + "\n" + h.getFuncionario().getId() + "\n" + h.getDtEntrada() + "\n" + h.getDtSaida() + "\n"
//        + h.getPercDesconto());

    }

}
