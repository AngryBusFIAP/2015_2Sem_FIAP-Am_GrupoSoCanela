package br.com.fiap.am.scn.bo;

import br.com.fiap.am.scn.dao.HospedagemDAO;
import br.com.fiap.am.scn.dao.ReservaDAO;
import br.com.fiap.am.scn.exception.Excecao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe de Regras de Negocio da Reserva
 * @see {@link br.com.fiap.am.scn.beans.Reserva}
 */
public class ReservaBO {

	/**
	 * Busca a data da reserva utilizando o codigo da reserva
	 * @param codReserva
	 * @return String com a data 
	 * @throws Excecao
	 */
    public String getDtReserva(int codReserva) throws Excecao {
        return new ReservaDAO().getDataReserva(codReserva);
    }

    /**
     * Metodo para verificar se a data esta dentro das regras de ser efetuada dentro de 24 horas
     * @param codReserva
     * @return boolean true=data validada/false=data invalida;
     * @throws Excecao
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
        } catch (ParseException e) {
            throw new Excecao(e);
        }
        return false;
    }
}
