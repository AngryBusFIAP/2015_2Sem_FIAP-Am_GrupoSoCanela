package br.com.fiap.am.scn.controller;

import br.com.fiap.am.scn.beans.*;
import br.com.fiap.am.scn.bo.HospedagemBO;
import br.com.fiap.am.scn.dao.*;
import br.com.fiap.am.scn.exception.Excecao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by
 *
 * @author vinylimaz
 *         on 26/10/15 & 19:27.
 *         ${NAME} é uma classe
 */
@WebServlet("ServletHotelBoaViagem")
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

    public void gerarRelatorio(HttpServletRequest request, HttpServletResponse response) throws Excecao {

        Reserva reserva = new Reserva();
        Cliente cliente = new Cliente();
        List<Consumo> produto = new ArrayList<Consumo>();
        List<Consumo> servico = new ArrayList<Consumo>();
//      Implementar o HistoricoValor na classe Quarto

        Hospedagem hospedagem = new Hospedagem();
        List<Quarto> quarto = new ArrayList<Quarto>();
        FormaPagamento formaPgto = new FormaPagamento();
        List<ReservaQuarto> reservaQuarto = new ArrayList<>();

        try {
            reserva = new ReservaDAO().getCodReserva(Integer.parseInt("cd_cliente"));

            hospedagem = new HospedagemDAO().getHospedagem(Integer.parseInt("cd_hospedagem"));
            produto = new ConsumoDAO().getProduto(Integer.parseInt("cd_hospedagem"));
            servico = new ConsumoDAO().getServico(Integer.parseInt(request.getParameter("cd_hospedagem")));
            //TODO modificar o metodo getQuarto para retornar o quarto de acordo com o cd_reserva
            reservaQuarto = new QuartoDAO().getQuartos(Integer.parseInt(request.getParameter("CD_RESERVA")));


//            formaPgto =


        } catch (Exception e) {
            throw new Excecao(e);
        }
    }

    public void registrarCheckin(HttpServletRequest request, HttpServletResponse response) throws Excecao {


        Reserva reserva = new Reserva();
        Quarto quarto = new Quarto();
        Cliente cliente = new Cliente();
        Funcionario funcionario = new Funcionario();

        reserva = new ReservaDAO().getReserva(Integer.parseInt(request.getParameter("CD_RESERVA")));

        quarto = new QuartoDAO().getQuarto(Integer.parseInt(request.getParameter("NR_QUARTO")));

        cliente = new ClienteDAO().getClienteCPF(Integer.parseInt(request.getParameter("NR_CPF")));

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