package br.com.fiap.am.scn.test;

import br.com.fiap.am.scn.beans.Quarto;
import br.com.fiap.am.scn.dao.QuartoDAO;
import br.com.fiap.am.scn.exception.Excecao;

/**
 * Created by Jardel on 21/10/2015.
 */
public class TesteQuartoDAO {

    public static void main(String[] args)throws Excecao{

        Quarto q = new Quarto();
        QuartoDAO qDAO = new QuartoDAO();



    //    q = qDAO.getQuarto(3);
    //    System.out.println(q.getNumero() + "\n" + q.getAndar() + "\n" +  q.getCapacidade());

    }

}
