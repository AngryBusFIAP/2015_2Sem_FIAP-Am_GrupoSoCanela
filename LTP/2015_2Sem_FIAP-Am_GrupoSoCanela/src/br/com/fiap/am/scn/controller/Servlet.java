package br.com.fiap.am.scn.controller;

import br.com.fiap.am.scn.beans.*;
import br.com.fiap.am.scn.bo.HospedagemBO;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if(request.getParameter("metodo").equalsIgnoreCase("buscarReserva")) {
            try {
                buscarReserva(request, response);
            } catch (Excecao e) {
                e.printStackTrace();
            }
        } else if (request.getParameter("metodo").contains("confirmarCheckin")){
            try {
                inserirHospedagem(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (request.getParameter("metodo").contains("buscarHospedagem")) {
            try {
                buscarHospedagem(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (request.getParameter("metodo").contains("confirmarCheckout")) {
            // todo chamar o metodo que finaliza o checkout
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void buscarReserva(HttpServletRequest request, HttpServletResponse response) throws Excecao, ServletException, IOException {

        Quarto quarto = new Quarto();
        Cliente cliente = new Cliente();

        Reserva reserva = new ReservaDAO().getReserva(Integer.parseInt(request.getParameter("cd_reserva")));
        reserva.setDtSolicitacao(mudaData(reserva.getDtSolicitacao()));
        reserva.setDtInicioReserva(mudaData(reserva.getDtInicioReserva()));
        reserva.setDtFimReserva(mudaData(reserva.getDtFimReserva()));
        reserva.getCliente().setDtNascimento(mudaData(reserva.getCliente().getDtNascimento()));
        request.setAttribute("reserva", reserva);
        request.setAttribute("cliente", cliente);
        request.setAttribute("quarto", quarto);

//        Cliente idCliente = clienteDAO.getClienteCPF(Integer.parseInt(request.getParameter("cpf")));
//        request.setAttribute("cliente", idCliente);


//        Quarto idQuarto = quartoDAO.getQuarto(Integer.parseInt(request.getParameter("nr_quarto")));
//        request.setAttribute("quarto", idQuarto);

//        String dtEntrada = request.getParameter("dt_entrada");
//
//        HospedagemDAO hospedagemDAO = new HospedagemDAO();

//        quarto = new QuartoDAO().getQuarto(reserva.getQuarto().getNumero());

//        cliente = new ClienteDAO().getClienteCPF(reserva.getCliente().getCpf());
//        //Integer.parseInt(request.getParameter("nr_cpf")));
//
//        Hospedagem hospedagem = new Hospedagem();
//        hospedagem.setQuarto(quarto);
//        hospedagem.setReserva(reserva);
//        hospedagem.setCliente(cliente);
//        hospedagem.setFuncionario(funcionario);
//        hospedagem.setDtEntrada("27/10/2015");
//        hospedagem.setDtSaida("30/10/2015");
//        hospedagem.setPercDesconto(0);
//
//        new HospedagemDAO().confirmHosp(hospedagem);
//
//        request.setAttribute("hospedagem", hospedagem);

        request.getRequestDispatcher("checkin.jsp").forward(request, response);

    }
    //SOMENTE PARA CORRIGIR A EXIBICAO!
    public String mudaData(String data) {
        String[] auxDt = new String[3];
        auxDt[2] = data.substring(0, 4);
        auxDt[1] = data.substring(4, 8);
        auxDt[0] = data.substring(8, 10);
        return (auxDt[0]+auxDt[1]+auxDt[2]).replace("-", "/");
    }

    public void inserirHospedagem(HttpServletRequest request, HttpServletResponse response) throws Excecao, ServletException, IOException {
        Reserva reserva = new ReservaDAO().getReserva(Integer.parseInt(request.getParameter("cd_reserva")));

        Hospedagem hospedagem = new Hospedagem();
        hospedagem.setReserva(reserva);

        hospedagem.setCliente(reserva.getCliente());

        Funcionario funcionario = new Funcionario();
        funcionario.setCodFuncionario(Integer.parseInt(request.getParameter("cd_funcionario")));
        if(funcionario.getCodFuncionario() < 0){
            funcionario.setCodFuncionario(8);
        }
        hospedagem.setFuncionario(funcionario);
        hospedagem.setDtEntrada(new HospedagemDAO().sysDate());
//        hospedagem.setDtHospedagem(new HospedagemDAO().sysDate());
        hospedagem.setDtSaida(request.getParameter("dt_final"));
        hospedagem.setPercDesconto(Double.parseDouble(request.getParameter("vc_perc_desconto")));

        hospedagem.setQuarto(reserva.getQuarto());

        new HospedagemBO().confirmHosp(hospedagem);
    }

    public void buscarHospedagem (HttpServletRequest request, HttpServletResponse response) throws Excecao, ServletException, IOException {

        Quarto quarto = new Quarto();
        Cliente cliente = new Cliente();
        Pagamento pagamento = new Pagamento();

        Hospedagem hospedagem = new HospedagemDAO().getHospedagem(Integer.parseInt("cd_hospedagem"));
        request.setAttribute("hospedagem", hospedagem);
        request.setAttribute("quarto", quarto);
        request.setAttribute("cliente", cliente);
        request.setAttribute("pagamento", pagamento);

        request.getRequestDispatcher("checkout.jsp").forward(request,response);



    }
}