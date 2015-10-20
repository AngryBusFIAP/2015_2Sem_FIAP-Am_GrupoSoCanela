package br.com.fiap.am.scn.dao;

import br.com.fiap.am.scn.beans.Funcionario;
import br.com.fiap.am.scn.connection.ConexaoFactory;
import br.com.fiap.am.scn.exception.Excecao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jardel on 20/10/2015.
 */
public class FuncionarioDAO {

    private Connection c;

    public FuncionarioDAO() throws Excecao{

        try{
        c = new ConexaoFactory().getConnection();
        }catch(Exception e){
        throw new Excecao();
        }
    }

    public Funcionario getFuncionario (int codigo) throws Excecao{

        Funcionario funcionario = new Funcionario();

        try {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM T_AM_SCN_FUNCIONARIO WHERE CD_FUNCIONARIO = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                funcionario.setCargo(rs.getInt("DS_CARGO"));
                funcionario.setDtAdmissao(rs.getString("DT_ADMISSAO"));
                rs.close();
                ps.close();
            }

        }catch(SQLException e){
            throw new Excecao(e);
        }
        return funcionario;
    }
}
