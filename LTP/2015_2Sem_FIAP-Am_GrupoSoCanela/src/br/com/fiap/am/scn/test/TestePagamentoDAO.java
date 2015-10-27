package br.com.fiap.am.scn.test;

import br.com.fiap.am.scn.beans.FormaPagamento;
import br.com.fiap.am.scn.beans.Hospedagem;
import br.com.fiap.am.scn.beans.Pagamento;
import br.com.fiap.am.scn.dao.FormaPagamentoDAO;
import br.com.fiap.am.scn.dao.HospedagemDAO;
import br.com.fiap.am.scn.dao.PagamentoDAO;
import br.com.fiap.am.scn.exception.Excecao;

/**
 * Created by Jardel on 22/10/2015.
 */
public class TestePagamentoDAO {

    public static void main(String[] args) throws Excecao{

        Hospedagem h = new Hospedagem();
        HospedagemDAO hDAO = new HospedagemDAO();
        FormaPagamento fp = new FormaPagamento();
        FormaPagamentoDAO fpDAO = new FormaPagamentoDAO();
        Pagamento pag = new Pagamento();
        PagamentoDAO pDAO = new PagamentoDAO();

        h = hDAO.getHospedagem(41);
        pag.setCodHospedagem(h);

        fp = fpDAO.getFormaPagamento(5);
        pag.setTipo(fp);

        pag.setDtPagamento("26/10/2015");
        pag.setValor(200.00);

        System.out.println(pDAO.confPagamento(pag));





        //p = pDAO.getPagamento(2);
        //System.out.println(p.getCodHospedagem() + "\n" + p.getFormaPagamento().getCodigo()+ "\n" + p.getValor() + "\n" + p.getDtPagamento());


    }
}
