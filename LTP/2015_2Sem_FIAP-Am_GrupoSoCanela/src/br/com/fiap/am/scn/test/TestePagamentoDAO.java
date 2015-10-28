package br.com.fiap.am.scn.test;

import br.com.fiap.am.scn.beans.Funcionario;
import br.com.fiap.am.scn.beans.Hospedagem;
import br.com.fiap.am.scn.bo.HospedagemBO;
import br.com.fiap.am.scn.dao.ReservaDAO;
import br.com.fiap.am.scn.exception.Excecao;

/**
 * Created by Jardel on 22/10/2015.
 */
public class TestePagamentoDAO {

    public static void main(String[] args) throws Excecao{

//        Hospedagem h = new Hospedagem();
//        HospedagemDAO hDAO = new HospedagemDAO();
//        FormaPagamento fp = new FormaPagamento();
//        FormaPagamentoDAO fpDAO = new FormaPagamentoDAO();
//        Pagamento pag = new Pagamento();
//        PagamentoDAO pDAO = new PagamentoDAO();
//
//        h = hDAO.getHospedagem(41);
//        pag.setCodHospedagem(h);
//
//        fp = fpDAO.getFormaPagamento(5);
//        pag.setTipo(fp);
//
//        pag.setDtPagamento("26/10/2015");
//        pag.setValor(200.00);
//
//        System.out.println(pDAO.confPagamento(pag));


        HospedagemBO hospedagemBO = new HospedagemBO();


        Hospedagem hospedagem = new Hospedagem();
        hospedagem.setReserva(new ReservaDAO().getReserva(2));
//        hospedagem.setFuncionario(new Funcionario().setCodFuncionario(1));






        hospedagemBO.confirmHosp(hospedagem);





        //p = pDAO.getPagamento(2);
        //System.out.println(p.getCodHospedagem() + "\n" + p.getFormaPagamento().getCodigo()+ "\n" + p.getValor() + "\n" + p.getDtPagamento());


    }
}
