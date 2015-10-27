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
 * Created by Jardel on 21/10/2015.
 */
public class QuartoDAO {

    private Connection c;

    public QuartoDAO() throws Excecao{

        try {
            c = new ConexaoFactory().getConnection();
        }catch (Exception e){
            throw new Excecao(e);
        }

    }

    public Quarto getQuarto(int quarto) throws Excecao{

        Quarto q = new Quarto();

        String sql = "SELECT * FROM T_AM_SCN_QUARTO WHERE NR_QUARTO =?";

        try{
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, quarto);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                q.setNumero(rs.getInt("NR_QUARTO"));
                rs.close();
                ps.close();
            }
        }catch (SQLException e){
            throw new Excecao(e);
        }
        return q;
    }


    public List<ReservaQuarto> getQuartos(int codReserva) throws Excecao{

        List<ReservaQuarto> listQuarto = new ArrayList<ReservaQuarto>();
        Reserva reserva = null;
        Quarto quarto = null;
        TipoQuarto tipoQuarto = null;
        HistoricoValor valorQuarto = null;
        ReservaQuarto reservaQuarto = null;
        String sql = "SELECT RQ.CD_RESERVA, Q.NR_QUARTO, RQ.QT_PESSOA_QUARTO, TQ.CD_TIPO_QUARTO ,TQ.DS_TIPO_QUARTO , RQ.DS_OBSERVACAO, HV.VL_PRECO_QUARTO "
                + "FROM T_AM_SCN_RESERVA_QUARTO RQ "
                + "JOIN T_AM_SCN_RESERVA R ON R.CD_RESERVA = RQ.CD_RESERVA "
                + "JOIN T_AM_SCN_QUARTO Q ON Q.NR_QUARTO = RQ.NR_QUARTO "
                + "JOIN T_AM_SCN_TIPO_QUARTO TQ ON TQ.CD_TIPO_QUARTO = Q.CD_TIPO_QUARTO "
                + "JOIN T_AM_SCN_HIST_VALOR HV ON HV.CD_TIPO_QUARTO = TQ.CD_TIPO_QUARTO "
                + "WHERE (SELECT MAX(DT_VALIDADE) FROM T_AM_SCN_HIST_VALOR "
                + "WHERE CD_TIPO_QUARTO = TQ.CD_TIPO_QUARTO) = DT_VALIDADE AND RQ.CD_RESERVA =? ";

        try{
        PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, codReserva);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                reservaQuarto = new ReservaQuarto();
                reserva = new Reserva();
                reserva.setCodReserva(rs.getInt("CD_RESERVA"));
                reservaQuarto.setReserva(reserva);
                quarto = new Quarto();
                quarto.setNumero(rs.getInt("NR_QUARTO"));
                quarto.setCapacidade(rs.getInt("QT_PESSOA_QUARTO"));
                tipoQuarto = new TipoQuarto();
                tipoQuarto.setCodTipoQuarto(rs.getInt("CD_TIPO_QUARTO"));
                tipoQuarto.setDescricao(rs.getString("DS_TIPO_QUARTO"));
                quarto.setTipo(tipoQuarto);
                valorQuarto = new HistoricoValor();
                valorQuarto.setVl_preco_quarto(rs.getDouble("VL_PRECO_QUARTO"));
                quarto.setValorQuarto(valorQuarto);
                reservaQuarto.setQuarto(quarto);
                reservaQuarto.setDescObservacao(rs.getString("DS_OBSERVACAO"));
                listQuarto.add(reservaQuarto);
//                rs.close();
//                ps.close();
            }

        }catch (SQLException e){
            throw new Excecao(e);
        }
        return listQuarto;
    }



}
