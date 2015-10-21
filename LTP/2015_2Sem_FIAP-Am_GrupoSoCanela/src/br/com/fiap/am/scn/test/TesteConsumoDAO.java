package br.com.fiap.am.scn.test;

import br.com.fiap.am.scn.beans.Consumo;
import br.com.fiap.am.scn.dao.ConsumoDAO;
import br.com.fiap.am.scn.exception.Excecao;

/**
 * Created by Jardel on 21/10/2015.
 */
public class TesteConsumoDAO {

    public static void main(String[]args) throws Excecao{

        Consumo c = new Consumo();
        ConsumoDAO cDAO = new ConsumoDAO();

        c = cDAO.getConsumo(5);
        System.out.println(c.getCodConsumo() + "\n" + c.getHospedagem().getCodHospedagem() + "\n"
                + c.getTipoServicos().getCodigo() + "\n" + c.getQtdeConsumo() + "\n" + c.getDtConsumo());

    }
}
