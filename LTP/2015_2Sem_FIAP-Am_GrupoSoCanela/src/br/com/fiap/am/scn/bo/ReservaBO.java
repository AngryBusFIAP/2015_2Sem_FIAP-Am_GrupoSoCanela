package br.com.fiap.am.scn.bo;

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
 *         on 25/10/15 & 15:05.
 *         ReservaBO é uma classe
 */
public class ReservaBO {


    public String getDtReserva(int codReserva) throws Excecao {
        return new ReservaDAO().getDataReserva(codReserva);
    }

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
        } catch (ParseException e) {
            throw new Excecao(e);
        }
        return false;
    }
}
