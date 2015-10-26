package br.com.fiap.am.scn.dao;

import br.com.fiap.am.scn.beans.FormaPagamento;
import br.com.fiap.am.scn.beans.Pagamento;
import br.com.fiap.am.scn.connection.ConexaoFactory;
import br.com.fiap.am.scn.exception.Excecao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jardel on 21/10/2015.
 */
public class PagamentoDAO {

    private Connection c;

    public PagamentoDAO() throws Excecao{

        try{
            c = new ConexaoFactory().getConnection();
        }catch (Exception e){
            throw new Excecao(e);
        }
    }

    public String confPagamento(Pagamento pagamento) throws Excecao{

        String sql = "INSERT INTO T_AM_SCN_PAGAMENTO VALUES(SQ_SCN)";

        try{
        PreparedStatement ps = c.prepareStatement(sql);
        }catch (SQLException e){
            throw new Excecao(e);
        }
        return "a";
    }


    public Pagamento getPagamento(int codigo)throws Excecao{
        Pagamento pagamento = new Pagamento();
        FormaPagamento formaPagamento = new FormaPagamento();

        try{
            PreparedStatement ps = c.prepareStatement("SELECT * FROM T_AM_SCN_PAGAMENTO WHERE CD_HOSPEDAGEM =?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                pagamento.setCodHospedagem(rs.getInt("CD_HOSPEDAGEM"));
                formaPagamento.setCodigo(rs.getInt("CD_TIPO_FORMAPAG"));
                pagamento.setDtPagamento(rs.getString("DT_PAGAMENTO"));
                pagamento.setValor(rs.getDouble("VL_PAGAMENTO"));
                pagamento.setTipo(formaPagamento);
                rs.close();
                ps.close();
            }
        }catch (SQLException e){
            throw new Excecao(e);
        }
        return pagamento;
    }

}
