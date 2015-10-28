package br.com.fiap.am.scn.dao;

import br.com.fiap.am.scn.beans.FormaPagamento;
import br.com.fiap.am.scn.beans.Hospedagem;
import br.com.fiap.am.scn.beans.Pagamento;
import br.com.fiap.am.scn.connection.ConexaoFactory;
import br.com.fiap.am.scn.exception.Excecao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe de acesso de dados do Pagamento;
 * @see {@link br.com.fiap.am.scn.beans.Pagamento}
 */
public class PagamentoDAO {

    private Connection connection;

    public PagamentoDAO() throws Excecao{

        try{
            connection = new ConexaoFactory().getConnection();
        }catch (Exception e){
            throw new Excecao(e);
        }
    }

    /**
     * Metodo para cadastrar o pagamento no banco
     * @param pagamento - Objeto pagamento
     * @return String mostrando se foi cadastrado ou nao
     * @throws Excecao
     */
    public String confPagamento(Pagamento pagamento) throws Excecao{

        String sql = "INSERT INTO T_AM_SCN_PAGAMENTO VALUES(?,?,?,?)";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
//            pagamento.setCodHospedagem(hospedagem);
//            pagamento.setTipo(formaPagamento);
            ps.setInt(1, pagamento.getCodHospedagem().getCodHospedagem());
            ps.setInt(2, pagamento.getFormaPagamento().getCodigo());
            ps.setString(3, pagamento.getDtPagamento());
            ps.setDouble(4, pagamento.getValor());
            ps.execute();
            ps.close();
        }catch (SQLException e){
            throw new Excecao("Problemas ao realizar o pagamento\nTente Novamente!\n"+e);
        }
        return "Pagamento confirmado com sucesso";
    }

    /**
     * Busca o pagamento pelo codigo da Hospedagem
     * @param codHospedagem
     * @return Objeto Pagamento
     * @throws Excecao
     */
    public Pagamento getPagamento(int codHospedagem)throws Excecao{

        Hospedagem hospedagem = new Hospedagem();
        Pagamento pagamento = new Pagamento();
        FormaPagamento formaPagamento = new FormaPagamento();

        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM T_AM_SCN_PAGAMENTO WHERE CD_HOSPEDAGEM =?");
            ps.setInt(1, codHospedagem);
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
