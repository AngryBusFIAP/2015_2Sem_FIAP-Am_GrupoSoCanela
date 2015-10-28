package br.com.fiap.am.scn.bo;

import br.com.fiap.am.scn.beans.*;
import br.com.fiap.am.scn.dao.HospedagemDAO;
import br.com.fiap.am.scn.dao.ReservaDAO;
import br.com.fiap.am.scn.exception.Excecao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    public boolean verifDtEntrada(int codReserva) throws Excecao {
        try {

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dataReserva = sdf.parse(new ReservaDAO().getDataReserva(codReserva));
            Date dataAtual = sdf.parse(new HospedagemDAO().sysDate());

            System.out.println(sdf.format(dataReserva));
            System.out.println(sdf.format(dataAtual));

            if (dataReserva.compareTo(dataAtual) == +1) {
                return false;
            } else if (dataReserva.compareTo(dataAtual) == -1) {
                dataAtual.setHours(-24);
                if (dataReserva.compareTo(dataAtual) == 0) {
//                        System.out.println("Verificação da data de reserva ser um dia menor que o dia de hoje");
                    return true;
                }


            } else if (dataReserva.compareTo(dataAtual) == 0) {
                return true;
            }

        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return false;
    }


    public String confirmHosp(Hospedagem hospedagem) throws Excecao{
        if(verifDtEntrada(hospedagem.getReserva().getCodReserva())) {
            return new HospedagemDAO().confirmHosp(hospedagem);
        }else{
            return "Impossivel realizar o checkin, favor verificar a data!";
        }
    }
}
