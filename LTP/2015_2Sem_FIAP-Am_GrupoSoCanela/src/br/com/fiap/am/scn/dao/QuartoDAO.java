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


    public List<ReservaQuarto> getQuarto(int codCliente) throws Excecao{

        List<ReservaQuarto> listQuarto = new ArrayList<ReservaQuarto>();

        Quarto quarto = new Quarto();
        TipoQuarto tipoQuarto = new TipoQuarto();
        HistoricoValor valorQuarto = new HistoricoValor();
        String sql = "SELECT rq.nr_quarto, rq.qt_pessoa_quarto, tq.cd_tipo_quarto, tq.ds_tipo_quarto, hq.dt_validade," +
                "hq.vl_preco_quarto"+
                "FROM T_AM_SCN_RESERVA_QUARTO RQ JOIN T_AM_SCN_RESERVA R" +
                "ON RQ.CD_RESERVA = R.CD_RESERVA" +
                "JOIN T_AM_SCN_QUARTO Q ON RQ.NR_QUARTO = Q.NR_QUARTO" +
                "JOIN T_AM_SCN_TIPO_QUARTO TQ ON TQ.CD_TIPO_QUARTO = HQ.CD_TIPO_QUARTO";

        try{
        PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, codCliente);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                quarto.setNumero(rs.getInt("NR_QUARTO"));
                tipoQuarto.setCodTipoQuarto(rs.getInt("CD_TIPO_QUARTO"));
                quarto.setAndar(rs.getInt("NR_ANDAR"));
                quarto.setCapacidade(rs.getInt("NR_CAPACIDADE"));
                rs.close();
                ps.close();
            }

        }catch (SQLException e){
            throw new Excecao(e);
        }
        return listQuarto;
    }



}
