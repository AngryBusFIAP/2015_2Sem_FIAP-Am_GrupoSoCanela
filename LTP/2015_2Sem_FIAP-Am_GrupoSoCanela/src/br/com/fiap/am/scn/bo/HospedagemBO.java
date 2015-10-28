package br.com.fiap.am.scn.bo;

import br.com.fiap.am.scn.beans.Hospedagem;
import br.com.fiap.am.scn.dao.HospedagemDAO;
import br.com.fiap.am.scn.exception.Excecao;

/**
 * Classe de Regras de negocio das Hospedagens
 *         @see {@link br.com.fiap.am.scn.beans.Hospedagem}
 */
public class HospedagemBO {

    /***
     * Metodo para verificacao da data de entrada, so pode ocorrer se for no mesmo dia ou ate 1 dia depois do reservado
     *
     * @return String se a data foi validada ou nao
     */

    public String confirmHosp(Hospedagem hospedagem) throws Excecao{
        if(new ReservaBO().verifDtEntrada(hospedagem.getReserva().getCodReserva())) {

            hospedagem.setDtEntrada(mudaDtBanco(hospedagem.getDtEntrada()));
            return new HospedagemDAO().confirmHosp(hospedagem);
        }else{
            return "Impossivel realizar o checkin, favor verificar a data!";
        }
    }

    public String mudaDtBanco(String data) {
        String[] auxDt = new String[3];
        auxDt[2] = data.substring(0, 4);
        auxDt[1] = data.substring(4, 8);
        auxDt[0] = data.substring(8, 10);
        return (auxDt[0]+auxDt[1]+auxDt[2]).replace("-", "/");
    }



}
