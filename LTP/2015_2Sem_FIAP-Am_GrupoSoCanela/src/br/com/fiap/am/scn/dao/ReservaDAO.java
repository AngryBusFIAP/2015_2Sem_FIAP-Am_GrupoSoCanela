package br.com.fiap.am.scn.dao;

import br.com.fiap.am.scn.beans.*;
import br.com.fiap.am.scn.connection.ConexaoFactory;
import br.com.fiap.am.scn.exception.Excecao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        ReservaQuarto reservaQuarto = new ReservaQuarto();
        Quarto quarto = new Quarto();
        TipoQuarto tipoQuarto = new TipoQuarto();
        Pessoa pessoa = new Pessoa();

        Reserva reserva = new Reserva();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT R.CD_RESERVA, C.CD_CLIENTE, C.NR_CPF, C.NR_RG, " +
                    "C.NR_QUARTO_PREFERIDO ,C.DT_NASCIMENTO, R.DT_SOLICITACAO, R.DT_INICIO_RESERVA, "
                    + "R.DT_FINAL_RESERVA, R.QT_ADULTO, R.QT_CRIANCA, R.ST_RESERVA, RQ.QT_PESSOA_QUARTO, Q.NR_ANDAR, Q.NR_QUARTO, TQ.DS_TIPO_QUARTO, P.NM_PESSOA "
                    + "FROM T_AM_SCN_RESERVA R "
                    + "JOIN T_AM_SCN_RESERVA_QUARTO RQ ON RQ.CD_RESERVA = R.CD_RESERVA "
                    + "JOIN T_AM_SCN_CLIENTE C ON C.CD_CLIENTE = R.CD_CLIENTE "
                    + "JOIN T_AM_SCN_PESSOA P ON P.CD_PESSOA = C.CD_CLIENTE "
                    + "JOIN T_AM_SCN_QUARTO Q ON Q.NR_QUARTO = RQ.NR_QUARTO "
                    + "JOIN T_AM_SCN_TIPO_QUARTO TQ ON TQ.CD_TIPO_QUARTO = Q.CD_TIPO_QUARTO "
                    + "WHERE R.CD_RESERVA =?");
            statement.setInt(1, codigoReserva);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                reserva.setCodReserva(resultSet.getInt("CD_RESERVA"));
                cliente.setId(resultSet.getInt("CD_CLIENTE"));
                cliente.setCpf(resultSet.getLong("NR_CPF"));
                cliente.setRg(resultSet.getString("NR_RG"));
                cliente.setDtNascimento(resultSet.getString("DT_NASCIMENTO"));
                cliente.setQuartoPreferido(resultSet.getInt("NR_QUARTO_PREFERIDO"));
                //  funcionario.setId(resultSet.getInt("CD_FUNCIONARIO"));
                reserva.setDtSolicitacao(resultSet.getString("DT_SOLICITACAO"));
                reserva.setDtInicioReserva(resultSet.getString("DT_INICIO_RESERVA"));
                reserva.setDtFimReserva(resultSet.getString("DT_FINAL_RESERVA"));
                reserva.setQtdHospedesAdulto(resultSet.getInt("QT_ADULTO"));
                reserva.setQtdHospedesCrianca(resultSet.getInt("QT_CRIANCA"));
                reserva.setStatus(resultSet.getInt("ST_RESERVA"));
                quarto.setCapacidade(resultSet.getInt("QT_PESSOA_QUARTO"));
                quarto.setAndar(resultSet.getInt("NR_ANDAR"));
                quarto.setNumero(resultSet.getInt("NR_QUARTO"));
                tipoQuarto.setDescricao(resultSet.getString("DS_TIPO_QUARTO"));
                cliente.setNome(resultSet.getString("NM_PESSOA"));
                quarto.setTipo(tipoQuarto);
                reserva.setQuarto(quarto);
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
        Reserva reserva = new Reserva();

        String strDtReserva = null;
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM T_AM_SCN_RESERVA WHERE CD_CLIENTE = ?");
            statement.setDouble(1, idCliente);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                reserva.setCodReserva(resultSet.getInt("CD_RESERVA"));
                reserva.setDtSolicitacao(resultSet.getString("DT_SOLICITACAO"));
            }

        }catch(SQLException e){
            throw new Excecao(e);
        }
        return reserva;
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
