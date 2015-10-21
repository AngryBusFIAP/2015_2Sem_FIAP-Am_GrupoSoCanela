package br.com.fiap.am.scn.dao;

import br.com.fiap.am.scn.beans.Quarto;
import br.com.fiap.am.scn.beans.Reserva;
import br.com.fiap.am.scn.connection.ConexaoFactory;
import br.com.fiap.am.scn.exception.Excecao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Jardel on 21/10/2015.
 */
public class ReservaQuartoDAO {

    private Connection c;

    public ReservaQuartoDAO() throws Excecao{

        try{
            c = new ConexaoFactory().getConnection();
        }catch(Exception e){
            throw new Excecao(e);
        }
    }

    public String getReservaQuarto(Reserva r, Quarto q) throws Excecao{

        Reserva reserva = new Reserva();
        Quarto quarto = new Quarto();

        try{
            PreparedStatement ps = c.prepareStatement("SELECT * FROM T_AM_SCN_RESERVA_QUARTO WHERE CD_RESERVA AND NR_QUARTO = ? ");
        }catch (SQLException e){
            throw new Excecao(e);
        }
        return "a";
    }

}
