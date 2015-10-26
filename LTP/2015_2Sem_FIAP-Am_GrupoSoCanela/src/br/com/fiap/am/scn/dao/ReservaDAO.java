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

    private Connection connection;

    public ReservaDAO() throws Excecao{

        try{
            connection = new ConexaoFactory().getConnection();
        }catch(Exception e){
            throw new Excecao(e);
        }
    }

    public Reserva getReserva(int codigoReserva) throws Excecao{

        Cliente cliente = new Cliente();
        Funcionario funcionario = new Funcionario();

        Reserva reserva = new Reserva();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM T_AM_SCN_RESERVA WHERE CD_RESERVA =?");
            statement.setInt(1, codigoReserva);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                reserva.setCodReserva(resultSet.getInt("CD_RESERVA"));
                cliente.setId(resultSet.getInt("CD_CLIENTE"));
                funcionario.setId(resultSet.getInt("CD_FUNCIONARIO"));
                reserva.setDtSolicitacao(resultSet.getString("DT_SOLICITACAO"));
                reserva.setDtInicioReserva(resultSet.getString("DT_INICIO_RESERVA"));
                reserva.setDtFimReserva(resultSet.getString("DT_FINAL_RESERVA"));
                reserva.setQtdHospedesAdulto(resultSet.getInt("QT_ADULTO"));
                reserva.setQtdHospedesCrianca(resultSet.getInt("QT_CRIANCA"));
                reserva.setStatus(resultSet.getInt("ST_RESERVA"));
                reserva.setCliente(cliente);
                reserva.setFuncionario(funcionario);
                resultSet.close();
                statement.close();
            }
        }catch(SQLException e){
            throw new Excecao(e);
        }

        return reserva;
    }

    public String getDataReserva(Cliente cliente) throws Excecao{
        String strDtReserva = null;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT DT_INICIO_RESERVA FROM T_AM_SCN_RESERVA WHERE CD_CLIENTE = ?");
            statement.setDouble(1, cliente.getId());
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                strDtReserva = (resultSet.getString("DT_INICIO_RESERVA"));
                resultSet.close();
                statement.close();
            }

        }catch(SQLException e){
            throw new Excecao(e);
        }
        return strDtReserva;
    }

    public Reserva getCodReserva(int idCliente) throws Excecao{
        Reserva r = new Reserva();

        String strDtReserva = null;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM T_AM_SCN_RESERVA WHERE CD_CLIENTE = ?");
            statement.setDouble(1, idCliente);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                r.setCodReserva(rs.getInt("CD_RESERVA"));
                r.setDtSolicitacao(rs.getString("DT_SOLICITACAO"));
            }

        }catch(SQLException e){
            throw new Excecao(e);
        }
        return r;
    }

    public String getDataReserva(int codReserva) throws Excecao{
        String dtReserva = null;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT DT_INICIO_RESERVA FROM T_AM_SCN_RESERVA WHERE CD_RESERVA = ?");
            statement.setInt(1, codReserva);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                dtReserva = resultSet.getString("DT_INICIO_RESERVA");
            }
        }catch (Exception e){
            new Excecao(e);
        }
        return dtReserva;
    }
}
