package br.com.fiap.am.scn.bo;

import br.com.fiap.am.scn.dao.ReservaDAO;
import br.com.fiap.am.scn.exception.Excecao;

/**
 * Created by
 *
 * @author vinylimaz
 *         on 25/10/15 & 15:05.
 *         ReservaBO é uma classe
 */
public class ReservaBO {


    public String getDtReserva(int codReserva) throws Excecao {
        return new ReservaDAO().getDataReserva(codReserva);
    }
}
