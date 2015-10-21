package br.com.fiap.am.scn.dao;

import br.com.fiap.am.scn.beans.ProdutoServico;
import br.com.fiap.am.scn.connection.ConexaoFactory;
import br.com.fiap.am.scn.exception.Excecao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Jardel on 21/10/2015.
 */
public class ProdutoServicoDAO {

    private Connection c;

    public ProdutoServicoDAO() throws Excecao{

        try{
            c = new ConexaoFactory().getConnection();
        }catch (Exception e){
            throw new Excecao(e);
        }
    }

    public ProdutoServico getProdutoServico (int codigo) throws Excecao{

        ProdutoServico produtoServico = new ProdutoServico();

        try{
            PreparedStatement ps = c.prepareStatement("");
        }catch (SQLException e){
            throw new Excecao(e);
        }
        return produtoServico;
    }


}
