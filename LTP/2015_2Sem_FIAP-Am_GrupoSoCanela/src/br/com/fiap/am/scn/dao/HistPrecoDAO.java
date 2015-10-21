package br.com.fiap.am.scn.dao;

import br.com.fiap.am.scn.beans.HistoricoPreco;
import br.com.fiap.am.scn.beans.TipoServico;
import br.com.fiap.am.scn.connection.ConexaoFactory;
import br.com.fiap.am.scn.exception.Excecao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jardel on 21/10/2015.
 */
public class HistPrecoDAO {

    private Connection c;

    public HistPrecoDAO() throws Excecao{

        try {
            c = new ConexaoFactory().getConnection();
        }catch (Exception e){
            throw new Excecao(e);
        }
    }

    public HistoricoPreco getHistoricoPreco (int codigo) throws Excecao{

        HistoricoPreco historicoPreco = new HistoricoPreco();
        TipoServico tipoServico = new TipoServico();

        try {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM T_AM_SCN_HIST_PRECO WHERE CD_HIST_PRECO =?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                historicoPreco.setCodHistPreco(rs.getInt("CD_HIST_PRECO"));
                tipoServico.setCodigo(rs.getInt("CD_TIPO_SERVICO"));
                historicoPreco.setDtValidade(rs.getString("DT_VALIDADE"));
                historicoPreco.setVlPreco(rs.getDouble("VL_PRECO"));
                historicoPreco.setTipoServico(tipoServico);
                rs.close();
                ps.close();
            }
        }catch (SQLException e){
            throw new Excecao(e);
        }
        return historicoPreco;
    }

}
