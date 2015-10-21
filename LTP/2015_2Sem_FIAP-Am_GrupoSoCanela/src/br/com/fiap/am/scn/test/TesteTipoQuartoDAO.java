package br.com.fiap.am.scn.test;

import br.com.fiap.am.scn.beans.TipoQuarto;
import br.com.fiap.am.scn.dao.TipoQuartoDAO;
import br.com.fiap.am.scn.exception.Excecao;

/**
 * Created by Jardel on 21/10/2015.
 */
public class TesteTipoQuartoDAO {

    public static void main(String[] args) throws Excecao{

        TipoQuarto tipoQuarto = new TipoQuarto();
        TipoQuartoDAO tQuartoDAO = new TipoQuartoDAO();

        tipoQuarto = tQuartoDAO.getTipoQuarto(1);
        System.out.println(tipoQuarto.getCodTipoQuarto() + "\n" + tipoQuarto.getObservacao() + "\n" + tipoQuarto.getDescricao());

    }
}
