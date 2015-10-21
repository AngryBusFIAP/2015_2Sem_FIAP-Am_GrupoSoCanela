package br.com.fiap.am.scn.test;

import br.com.fiap.am.scn.beans.HistoricoPreco;
import br.com.fiap.am.scn.dao.HistPrecoDAO;
import br.com.fiap.am.scn.exception.Excecao;

/**
 * Created by Jardel on 21/10/2015.
 */
public class TesteHistPrecoDAO {

    public static void main(String[] args)throws Excecao{

        HistoricoPreco hp = new HistoricoPreco();
        HistPrecoDAO hpDAO = new HistPrecoDAO();

        hp = hpDAO.getHistoricoPreco(3);
        System.out.println(hp.getCodHistPreco() + "\n" + hp.getTipoServico().getCodigo() + "\n" + hp.getVlPreco());
    }
}
