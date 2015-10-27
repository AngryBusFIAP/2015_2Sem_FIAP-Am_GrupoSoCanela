package br.com.fiap.am.scn.dao;

import br.com.fiap.am.scn.beans.FormaPagamento;
import br.com.fiap.am.scn.beans.Hospedagem;
import br.com.fiap.am.scn.beans.Pagamento;
import br.com.fiap.am.scn.beans.TipoPagamento;
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

        Hospedagem hospedagem = new Hospedagem();
        FormaPagamento formaPagamento = new FormaPagamento();


        String sql = "INSERT INTO T_AM_SCN_PAGAMENTO VALUES(?,?,?,?)";

        try{
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, pagamento.getCodHospedagem().getCodHospedagem());
            pagamento.setCodHospedagem(hospedagem);
            ps.setInt(2, pagamento.getFormaPagamento().getCodigo());
            pagamento.setTipo(formaPagamento);
            ps.setString(3, pagamento.getDtPagamento());
            ps.setDouble(4, pagamento.getValor());
            ps.execute();
            ps.close();
        }catch (SQLException e){
            throw new Excecao(e);
        }
        return "Pagamento confirmado com sucesso";
    }


    public Pagamento getPagamento(int codigo)throws Excecao{

        Hospedagem hospedagem = new Hospedagem();
        Pagamento pagamento = new Pagamento();
        FormaPagamento formaPagamento = new FormaPagamento();

        try{
            PreparedStatement ps = c.prepareStatement("SELECT * FROM T_AM_SCN_PAGAMENTO WHERE CD_HOSPEDAGEM =?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                hospedagem.setCodHospedagem(rs.getInt("CD_HOSPEDAGEM"));
                pagamento.setCodHospedagem(hospedagem);
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
