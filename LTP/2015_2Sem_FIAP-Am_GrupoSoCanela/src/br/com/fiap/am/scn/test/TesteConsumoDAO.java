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

        //c = cDAO.getConsumo(2);
        for(Consumo con : cDAO.getConsumo(2)){
            System.out.println(con.getCodConsumo() + con.getTipoServicos().getDescricao()
                    + con.getHospedagem().getCodHospedagem() + "\n" +con.getHistoricoPreco().getVlPreco());
        }

       // System.out.println(c.getCodConsumo() + "\n" + c.getHospedagem().getCodHospedagem() + "\n" +c.getTipoServicos().getDescricao() + "\n" + + c.getTipoServicos().getValor() + "\n"
         //       + c.getTipoServicos().getCodigo() + "\n" + c.getQtdeConsumo() + "\n" + c.getDtConsumo());

    }
}
