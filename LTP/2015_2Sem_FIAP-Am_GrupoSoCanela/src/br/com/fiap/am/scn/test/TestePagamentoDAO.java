package br.com.fiap.am.scn.test;

import br.com.fiap.am.scn.beans.Pagamento;
import br.com.fiap.am.scn.dao.PagamentoDAO;
import br.com.fiap.am.scn.exception.Excecao;

/**
 * Created by Jardel on 22/10/2015.
 */
public class TestePagamentoDAO {

    public static void main(String[] args) throws Excecao{

        Pagamento p = new Pagamento();
        PagamentoDAO pDAO = new PagamentoDAO();

        p = pDAO.getPagamento(2);
        System.out.println(p.getCodHospedagem() + "\n" + p.getFormaPagamento().getCodigo()+ "\n" + p.getValor() + "\n" + p.getDtPagamento());


    }
}
