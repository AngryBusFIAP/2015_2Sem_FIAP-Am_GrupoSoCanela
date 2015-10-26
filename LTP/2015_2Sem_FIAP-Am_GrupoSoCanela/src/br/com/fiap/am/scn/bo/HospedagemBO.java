package br.com.fiap.am.scn.bo;

import br.com.fiap.am.scn.dao.ReservaDAO;
import br.com.fiap.am.scn.exception.Excecao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by
 *
 * @author vinylimaz
 *         on 20/10/15 & 20:12.
 *         HospedagemBO é uma classe
 */
public class HospedagemBO {

    /***
     * Metodo para verificação da data de entrada, só pode ocorrer se for no mesmo dia ou até 1 dia depois do reservado
     * @return
     */

    @Deprecated
    public String verifDtEntrada2() throws Excecao {
        //Data do sistema
        Date sysDt = new Date(System.currentTimeMillis());
        String[] auxDt = sysDt.toString().split("-");

        int[] sysDate = new int[auxDt.length];

        for(int i = 0; i < auxDt.length; i++){
            sysDate[i] = Integer.parseInt(String.valueOf(auxDt[i]));
            System.out.println(sysDate[i]);
        }

//        String dataAuxReserva = new ReservaDAO().getDataReserva();
        String dataAuxReserva = "2015-10-20";

        //TODO Verificar como o banco retorna essa String
        auxDt = dataAuxReserva.split("-");

//        dataAuxReserva = null;
//        dataAuxReserva.concat(auxDt[2] + "-" + auxDt[1] + "-" + auxDt[0]);

        int[] dataReserva = new int[auxDt.length];


        for(int i = 0; i < auxDt.length; i++){
            dataReserva[i] = Integer.parseInt(String.valueOf(auxDt[i]));
        }


        if (dataReserva[0] == sysDate[0] && dataReserva[1] == sysDate[1]) {
            if(dataReserva[2] == sysDate[2]){
                System.out.println("Reserva e sistema são iguais");
            }else{
                if((dataReserva[2]+1) == sysDate[2]){
                    System.out.println("Data reservada e 24h da do sistema");
                }else{
                    throw new Excecao("Tempo de reserva expirado! Favor realizar nova reserva");
                }
            }
        }

        return "";
    }

    public boolean verifDtEntrada(int codReserva) throws Excecao, ParseException {

//        Calendar dataReserva = Calendar.getInstance();
//        dataReserva.setTime(new ReservaBO().getDtReserva(codReserva));
//        dataReserva.set(Calendar.HOUR_OF_DAY,0);
//        dataReserva.set(Calendar.MINUTE, 0);
//        dataReserva.set(Calendar.SECOND, 0);
//        dataReserva.set(Calendar.MILLISECOND, 0);
//        System.out.println(dataReserva.getTime());
//
//        Calendar dataAtual = Calendar.getInstance();
//        dataAtual.set(Calendar.HOUR_OF_DAY,0);
//        dataAtual.set(Calendar.SECOND, 0);
//        dataAtual.set(Calendar.MINUTE, 0);
//        dataAtual.set(Calendar.MILLISECOND, 0);
//        System.out.println(dataAtual.getTime());
//
//        Calendar dataAmanha = Calendar.getInstance();
//        dataAmanha.set(Calendar.HOUR_OF_DAY,0);
//        dataAmanha.set(Calendar.SECOND, 0);
//        dataAmanha.set(Calendar.MINUTE, 0);
//        dataAmanha.add(Calendar.DAY_OF_MONTH, -1);
//        System.out.println(dataAmanha.getTime());
//
//
//        //Reduzir
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar dtReserva = Calendar.getInstance();
        dtReserva.setTime(dateFormat.parse(new ReservaDAO().getDataReserva(codReserva)));
        Calendar hoje = Calendar.getInstance();

        if(dtReserva.compareTo(hoje) == 0){
            return true;
        }else{
            hoje.add(hoje.DAY_OF_MONTH, 1);
            if(dtReserva.compareTo(hoje) == 0){
                return true;
            }else{
                return false;
            }
        }
    }

}
