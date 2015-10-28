package br.com.fiap.am.scn.controller;

import br.com.fiap.am.scn.beans.*;
import br.com.fiap.am.scn.dao.ClienteDAO;
import br.com.fiap.am.scn.dao.HospedagemDAO;
import br.com.fiap.am.scn.dao.ReservaDAO;
import br.com.fiap.am.scn.exception.Excecao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by
 *
 * @author vinylimaz
 *         on 26/10/15 & 19:27.
 *         ${NAME} é uma classe
 */

public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            registrarCheckin(request, response);
        } catch (Excecao excecao) {
            excecao.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void registrarCheckin(HttpServletRequest request, HttpServletResponse response) throws Excecao {


        Reserva reserva = new Reserva();
        Quarto quarto = new Quarto();
        Cliente cliente = new Cliente();
        Funcionario funcionario = new Funcionario();

        reserva = new ReservaDAO().getReserva(Integer.parseInt(request.getParameter("cd_reserva")));

//        quarto = new QuartoDAO().getQuarto(reserva.getQuarto().getNumero());

        cliente = new ClienteDAO().getClienteCPF(reserva.getCliente().getCpf());
                //Integer.parseInt(request.getParameter("nr_cpf")));

        Hospedagem hospedagem = new Hospedagem();
        hospedagem.setQuarto(quarto);
        hospedagem.setReserva(reserva);
        hospedagem.setCliente(cliente);
        hospedagem.setFuncionario(funcionario);
        hospedagem.setDtEntrada(request.getParameter("27/10/2015"));
        hospedagem.setDtSaida(request.getParameter("30/10/2015"));
        hospedagem.setPercDesconto(0);

        new HospedagemDAO().confirmHosp(hospedagem);

        request.setAttribute("hospedagem", hospedagem);
        try {
            request.getRequestDispatcher("resultado.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}