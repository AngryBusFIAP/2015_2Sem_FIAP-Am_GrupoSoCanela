package br.com.fiap.am.scn.bo;

import br.com.fiap.am.scn.beans.Hospedagem;
import br.com.fiap.am.scn.dao.HospedagemDAO;
import br.com.fiap.am.scn.exception.Excecao;

/**
 * Created by
 *
 * @author vinylimaz
 *         on 20/10/15 & 20:12.
 *         HospedagemBO é uma classe que valida as regras de negocio relacionadas a Hospedagem
 *         @see br.com.fiap.am.scn.beans.Hospedagem
 */
public class HospedagemBO {

    /***
     * Metodo para verificação da data de entrada, só pode ocorrer se for no mesmo dia ou até 1 dia depois do reservado
     *
     * @return
     */

    public String confirmHosp(Hospedagem hospedagem) throws Excecao{
        if(new ReservaBO().verifDtEntrada(hospedagem.getReserva().getCodReserva())) {
            return new HospedagemDAO().confirmHosp(hospedagem);
        }else{
            return "Impossivel realizar o checkin, favor verificar a data!";
        }
    }
}
