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
 * Classe de Acesso de Dados de Consumo
 */
public class ConsumoDAO {

    private Connection c;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public ConsumoDAO() throws Excecao{

        try{
            c = new ConexaoFactory().getConnection();
        }catch (Exception e){
            throw new Excecao(e);
        }
    }

    public List<Consumo> getProduto(int codHospedagem) throws Excecao{

        List<Consumo> consumos = new ArrayList<Consumo>();

        Consumo consumo = null;
        Hospedagem hospedagem = null;
        TipoServico tipoServico = null;
        Funcionario funcionario = null;
        HistoricoPreco historicoPreco = null;

        try{
            //PreparedStatement ps = c.prepareStatement("SELECT * FROM T_AM_SCN_CONSUMO WHERE CD_CONSUMO =?");
            sql=    "SELECT C.CD_CONSUMO, H.CD_HOSPEDAGEM, PS.CD_TIPO_SERVICO, PS.DS_SERVICO, F.CD_FUNCIONARIO, HP.VL_PRECO, MAX(HP.DT_VALIDADE)AS DT_VALIDADE,C.DT_CONSUMO, C.QT_CONSUMO FROM T_AM_SCN_HIST_PRECO HP "
                    + "INNER JOIN T_AM_SCN_PRODUTO_SERVICO PS ON (PS.CD_TIPO_SERVICO = HP.CD_TIPO_SERVICO) "
                    + "INNER JOIN T_AM_SCN_CONSUMO C ON (C.CD_TIPO_SERVICO = PS.CD_TIPO_SERVICO) "
                    + "INNER JOIN T_AM_SCN_HOSPEDAGEM H ON (H.CD_HOSPEDAGEM = C.CD_HOSPEDAGEM) "
                    + "INNER JOIN T_AM_SCN_FUNCIONARIO F ON (F.CD_FUNCIONARIO = C.CD_FUNCIONARIO) "
                    + "WHERE (SELECT MAX(DT_VALIDADE) FROM T_AM_SCN_HIST_PRECO WHERE CD_TIPO_SERVICO = HP.CD_TIPO_SERVICO) = DT_VALIDADE AND C.CD_HOSPEDAGEM = ? AND PS.NR_TIPO = 1 "
                    + "group by C.CD_CONSUMO, H.CD_HOSPEDAGEM, PS.CD_TIPO_SERVICO, PS.DS_SERVICO, F.CD_FUNCIONARIO, HP.VL_PRECO, C.DT_CONSUMO, C.QT_CONSUMO ";

            ps = c.prepareStatement(sql);
            ps.setInt(1, codHospedagem);
            rs = ps.executeQuery();
            while(rs.next()){
                consumo = new Consumo();
                consumo.setCodConsumo(rs.getInt("CD_CONSUMO"));
                hospedagem = new Hospedagem();
                hospedagem.setCodHospedagem(rs.getInt("CD_HOSPEDAGEM"));
                consumo.setHospedagem(hospedagem);
                tipoServico = new TipoServico();
                tipoServico.setCodigo(rs.getInt("CD_TIPO_SERVICO"));
                tipoServico.setDescricao(rs.getString("DS_SERVICO"));
                consumo.setTipoServicos(tipoServico);
                funcionario = new Funcionario();
                funcionario.setCodFuncionario(rs.getInt("CD_FUNCIONARIO"));
                consumo.setCodFuncionario(funcionario);
                historicoPreco = new HistoricoPreco();
                historicoPreco.setVlPreco(rs.getDouble("VL_PRECO"));
                historicoPreco.setDtValidade(rs.getString("DT_VALIDADE"));
                consumo.setHistoricoPreco(historicoPreco);
                consumo.setDtConsumo(rs.getString("DT_CONSUMO"));
                consumo.setQtdeConsumo(rs.getInt("QT_CONSUMO"));
                consumos.add(consumo);
//                rs.close();
//                ps.close();
            }
        }catch(SQLException e){
            throw new Excecao(e);
        }
        return consumos;
    }

    public List<Consumo> getServico(int codHospedagem) throws Excecao{

        List<Consumo> consumos = new ArrayList<Consumo>();

        Consumo consumo = null;
        Hospedagem hospedagem = null;
        TipoServico tipoServico = null;
        Funcionario funcionario = null;
        HistoricoPreco historicoPreco = null;

        try{
            //PreparedStatement ps = c.prepareStatement("SELECT * FROM T_AM_SCN_CONSUMO WHERE CD_CONSUMO =?");
            sql=    "SELECT C.CD_CONSUMO, H.CD_HOSPEDAGEM, PS.CD_TIPO_SERVICO, PS.DS_SERVICO, F.CD_FUNCIONARIO, HP.VL_PRECO, MAX(HP.DT_VALIDADE)AS DT_VALIDADE,C.DT_CONSUMO, C.QT_CONSUMO FROM T_AM_SCN_HIST_PRECO HP "
                    + "INNER JOIN T_AM_SCN_PRODUTO_SERVICO PS ON (PS.CD_TIPO_SERVICO = HP.CD_TIPO_SERVICO) "
                    + "INNER JOIN T_AM_SCN_CONSUMO C ON (C.CD_TIPO_SERVICO = PS.CD_TIPO_SERVICO) "
                    + "INNER JOIN T_AM_SCN_HOSPEDAGEM H ON (H.CD_HOSPEDAGEM = C.CD_HOSPEDAGEM) "
                    + "INNER JOIN T_AM_SCN_FUNCIONARIO F ON (F.CD_FUNCIONARIO = C.CD_FUNCIONARIO) "
                    + "WHERE (SELECT MAX(DT_VALIDADE) FROM T_AM_SCN_HIST_PRECO WHERE CD_TIPO_SERVICO = HP.CD_TIPO_SERVICO) = DT_VALIDADE AND C.CD_HOSPEDAGEM = ? AND PS.NR_TIPO = 2 "
                    + "group by C.CD_CONSUMO, H.CD_HOSPEDAGEM, PS.CD_TIPO_SERVICO, PS.DS_SERVICO, F.CD_FUNCIONARIO, HP.VL_PRECO, C.DT_CONSUMO, C.QT_CONSUMO ";

            ps = c.prepareStatement(sql);
            ps.setInt(1, codHospedagem);
            rs = ps.executeQuery();
            while(rs.next()){
                consumo = new Consumo();
                consumo.setCodConsumo(rs.getInt("CD_CONSUMO"));
                hospedagem = new Hospedagem();
                hospedagem.setCodHospedagem(rs.getInt("CD_HOSPEDAGEM"));
                consumo.setHospedagem(hospedagem);
                tipoServico = new TipoServico();
                tipoServico.setCodigo(rs.getInt("CD_TIPO_SERVICO"));
                tipoServico.setDescricao(rs.getString("DS_SERVICO"));
                consumo.setTipoServicos(tipoServico);
                funcionario = new Funcionario();
                funcionario.setCodFuncionario(rs.getInt("CD_FUNCIONARIO"));
                consumo.setCodFuncionario(funcionario);
                historicoPreco = new HistoricoPreco();
                historicoPreco.setVlPreco(rs.getDouble("VL_PRECO"));
                historicoPreco.setDtValidade(rs.getString("DT_VALIDADE"));
                consumo.setHistoricoPreco(historicoPreco);
                consumo.setDtConsumo(rs.getString("DT_CONSUMO"));
                consumo.setQtdeConsumo(rs.getInt("QT_CONSUMO"));
                consumos.add(consumo);
//                rs.close();
//                ps.close();
            }
        }catch(SQLException e){
            throw new Excecao(e);
        }
        return consumos;
    }

}
