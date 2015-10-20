package br.com.fiap.am.scn.dao;

import br.com.fiap.am.scn.beans.Pessoa;
import br.com.fiap.am.scn.connection.ConexaoFactory;
import br.com.fiap.am.scn.exception.Excecao;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jardel on 19/10/2015.
 */
public class PessoaDAO {

    private Connection c;

    public PessoaDAO() throws Excecao {
        try{
            c = new ConexaoFactory().getConnection();
        }catch(Exception e){
            throw new Excecao(e);
        }
    }

    public String cadastrarPessoa(Pessoa pe) throws Excecao {

        String sql = "INSERT INTO T_AM_SCN_PESSOA VALUES (SQ_SCN_PESSOA.NEXTVAL, ?)";

        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, pe.getNome());
            ps.execute();

        } catch (SQLException e) {
            throw new Excecao(e);
        }
        return "Pessoa cadastrada com sucesso";
    }

    public String atualizarPessoa(int idPessoa, String nmPessoa) throws Excecao{

        String sql = "UPDATE T_AM_SCN_PESSOA SET CD_PESSOA = ? WHERE CD_PESSOA = ?";

        try{
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, idPessoa);
            ps.setString(2, nmPessoa);
            ps.executeUpdate();
            ps.close();
            return "Registro atualizado com sucesso";
        }catch (SQLException e){
            throw new Excecao(e);
        }
    }

    public int deletarPessoa(int idPessoa) throws Excecao{

        String sql = "DELETE FROM T_AM_SCN_PESSOA WHERE CD_PESSOA = ?";

        try{
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, idPessoa);
            int saida = ps.executeUpdate();
            ps.close();
            return saida;
        }catch(SQLException e){
            throw new Excecao(e);
        }
    }

    public Pessoa getPessoa(int codigo) throws Excecao{
        Pessoa pessoa = new Pessoa();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM T_AM_SCN_PESSOA WHERE CD_PESSOA = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                pessoa.setNome(rs.getString("NM_PESSOA"));
            }
            rs.close();
            ps.close();
        }catch(SQLException e){
            throw new Excecao(e);
        }
        return pessoa;
    }

    public Pessoa getPessoaNome(String pNome) throws Excecao{
        Pessoa pessoa = new Pessoa();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM T_AM_SCN_PESSOA WHERE NM_PESSOA = ?");
            ps.setString(1, pNome);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                pessoa.setNome(rs.getString("NM_PESSOA"));
            }
            rs.close();
            ps.close();
        }catch(SQLException e){
            throw new Excecao(e);
        }
        return pessoa;
    }

}
