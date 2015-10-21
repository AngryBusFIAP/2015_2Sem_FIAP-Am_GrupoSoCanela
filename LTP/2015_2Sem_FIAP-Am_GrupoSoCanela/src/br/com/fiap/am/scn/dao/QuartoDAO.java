package br.com.fiap.am.scn.dao;

import br.com.fiap.am.scn.beans.Quarto;
import br.com.fiap.am.scn.beans.TipoQuarto;
import br.com.fiap.am.scn.connection.ConexaoFactory;
import br.com.fiap.am.scn.exception.Excecao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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


    public Quarto getQuarto(int codigo) throws Excecao{

        Quarto quarto = new Quarto();
        TipoQuarto tipoQuarto = new TipoQuarto();

        try{
        PreparedStatement ps = c.prepareStatement("SELECT * FROM T_AM_SCN_QUARTO WHERE NR_QUARTO =?");
            ps.setInt(1, codigo);
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
        return quarto;
    }
}
