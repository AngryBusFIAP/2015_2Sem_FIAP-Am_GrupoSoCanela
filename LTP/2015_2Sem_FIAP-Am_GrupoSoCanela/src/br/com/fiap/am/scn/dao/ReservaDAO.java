package br.com.fiap.am.scn.dao;

import br.com.fiap.am.scn.beans.Cliente;
import br.com.fiap.am.scn.beans.Funcionario;
import br.com.fiap.am.scn.beans.Reserva;
import br.com.fiap.am.scn.connection.ConexaoFactory;
import br.com.fiap.am.scn.exception.Excecao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jardel on 20/10/2015.
 */
public class ReservaDAO {

    private Connection c;

    public ReservaDAO() throws Excecao{

        try{
            c = new ConexaoFactory().getConnection();
        }catch(Exception e){
            throw new Excecao(e);
        }
    }

    public Reserva getReserva(int codigo) throws Excecao{

        Cliente cli = new Cliente();
        Funcionario fun = new Funcionario();


        Reserva reserva = new Reserva();
        try{
            PreparedStatement ps = c.prepareStatement("SELECT * FROM T_AM_SCN_RESERVA WHERE CD_RESERVA =?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                reserva.setCodReserva(rs.getInt("CD_RESERVA"));
                cli.setId(rs.getInt("CD_CLIENTE"));
                fun.setId(rs.getInt("CD_FUNCIONARIO"));
                reserva.setDtSolicitacao(rs.getString("DT_SOLICITACAO"));
                reserva.setDtInicioReserva(rs.getString("DT_INICIO_RESERVA"));
                reserva.setDtFimReserva(rs.getString("DT_FINAL_RESERVA"));
                reserva.setQtdHospedesAdulto(rs.getInt("QT_ADULTO"));
                reserva.setQtdHospedesCrianca(rs.getInt("QT_CRIANCA"));
                reserva.setStatus(rs.getInt("ST_RESERVA"));
                reserva.setCliente(cli);
                reserva.setFuncionario(fun);
                rs.close();
                ps.close();
            }
        }catch(SQLException e){
            throw new Excecao(e);
        }

        return reserva;
    }

}
