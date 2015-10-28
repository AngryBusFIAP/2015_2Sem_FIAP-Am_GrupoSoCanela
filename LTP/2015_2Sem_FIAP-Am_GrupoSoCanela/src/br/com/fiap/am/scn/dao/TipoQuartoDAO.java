package br.com.fiap.am.scn.dao;

import br.com.fiap.am.scn.beans.TipoQuarto;
import br.com.fiap.am.scn.connection.ConexaoFactory;
import br.com.fiap.am.scn.exception.Excecao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe de Acesso de Dados do TipoQuarto
 */
public class TipoQuartoDAO {

    private Connection c;

    public TipoQuartoDAO() throws Excecao {

        try {
            c = new ConexaoFactory().getConnection();
        } catch (Exception e) {
            throw new Excecao(e);
        }
    }

    /**
     * Busca o tipo de quarto utilizando o codigo do tipo
     * @param codigo - Codigo do Tipo de Quarto
     * @return Objeto TipoQuarto
     * @throws Excecao
     */
    public TipoQuarto getTipoQuarto(int codigo) throws Excecao{

        TipoQuarto tipoQuarto = new TipoQuarto();

        try {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM T_AM_SCN_TIPO_QUARTO WHERE CD_TIPO_QUARTO =?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                tipoQuarto.setCodTipoQuarto(rs.getInt("CD_TIPO_QUARTO"));
                tipoQuarto.setDescricao(rs.getString("DS_TIPO_QUARTO"));
                tipoQuarto.setObservacao(rs.getString("DS_OBSERVACAO"));
                rs.close();
                ps.close();
            }
        }catch (SQLException e){
            throw new Excecao(e);
        }
        return tipoQuarto;
    }
}
