package br.com.fiap.am.scn.dao;

import br.com.fiap.am.scn.beans.FormaPagamento;
import br.com.fiap.am.scn.connection.ConexaoFactory;
import br.com.fiap.am.scn.exception.Excecao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe de acesso de dados da Forma de pagamento
 */
public class FormaPagamentoDAO {

    private Connection c;

    public FormaPagamentoDAO() throws Excecao{

        try{
            c = new ConexaoFactory().getConnection();
        }catch (Exception e){
            throw new Excecao(e);
        }
    }

    /**
    * Busca a forma de pagamento pelo codigo da forma de pagamento 
     * @param codigo - codigo da forma de pagamento
     * @return Objeto Forma de Pagamento
     * @throws Excecao
     */
    public FormaPagamento getFormaPagamento(int codigo) throws Excecao{

        FormaPagamento fp = new FormaPagamento();

        try{
            PreparedStatement ps = c.prepareStatement("SELECT * FROM T_AM_SCN_TIPO_FORMAPAG WHERE CD_TIPO_FORMAPAG=? ");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                fp.setCodigo(rs.getInt("CD_TIPO_FORMAPAG"));
                fp.setDescricao(rs.getString("DS_FORMAPAG"));
            }
        }catch (SQLException e){
            throw new Excecao(e);
        }
        return fp;
    }


}
