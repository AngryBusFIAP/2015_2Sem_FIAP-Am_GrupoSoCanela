package br.com.fiap.am.scn.dao;

import br.com.fiap.am.scn.beans.*;
import br.com.fiap.am.scn.connection.ConexaoFactory;
import br.com.fiap.am.scn.exception.Excecao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jardel on 21/10/2015.
 */
public class ConsumoDAO {

    private Connection c;

    public ConsumoDAO() throws Excecao{

        try{
            c = new ConexaoFactory().getConnection();
        }catch (Exception e){
            throw new Excecao(e);
        }
    }

    public Consumo getConsumo(int codigo) throws Excecao{

        Consumo consumo = new Consumo();
        Hospedagem hospedagem = new Hospedagem();
        TipoServico tipoServico = new TipoServico();
        Funcionario funcionario = new Funcionario();

        try{
            PreparedStatement ps = c.prepareStatement("SELECT * FROM T_AM_SCN_CONSUMO WHERE CD_CONSUMO =?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                consumo.setCodConsumo(rs.getInt("CD_CONSUMO"));
                hospedagem.setCodHospedagem(rs.getInt("CD_HOSPEDAGEM"));
                tipoServico.setCodigo(rs.getInt("CD_TIPO_SERVICO"));
                funcionario.setCodFuncionario(rs.getInt("CD_FUNCIONARIO"));
                consumo.setDtConsumo(rs.getString("DT_CONSUMO"));
                consumo.setQtdeConsumo(rs.getInt("QT_CONSUMO"));
                rs.close();
                ps.close();
            }
        }catch(SQLException e){
            throw new Excecao(e);
        }
        return consumo;
    }

}
