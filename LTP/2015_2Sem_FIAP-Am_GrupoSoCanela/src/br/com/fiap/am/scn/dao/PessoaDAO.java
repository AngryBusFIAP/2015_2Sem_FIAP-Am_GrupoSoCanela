package br.com.fiap.am.scn.dao;

import br.com.fiap.am.scn.beans.Pessoa;
import br.com.fiap.am.scn.connection.ConexaoFactory;
import br.com.fiap.am.scn.exception.Excecao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe de acesso de dados de Pessoa
 */
public class PessoaDAO {

    private Connection c = null;

    public PessoaDAO() throws Excecao {
        try{
            c = new ConexaoFactory().getConnection();
        }catch(Exception e){
            throw new Excecao(e);
        }
    }
    
    /**
     * Metodo para cadastrar Pessoa
     * @param pessoa
     * @return String com o resultado da operacao
     * @throws Excecao
     * @deprecated
     */
    public String cadastrarPessoa(Pessoa pessoa) throws Excecao {

        String sql = "INSERT INTO T_AM_SCN_PESSOA VALUES (SQ_SCN_PESSOA.NEXTVAL, ?)";

        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, pessoa.getNome());
            ps.execute();

        } catch (SQLException e) {
            throw new Excecao(e);

        }
        return "Pessoa cadastrada com sucesso";
    }

    /**
     * Metodo para atualizar Pessoa no banco de dados
     * @param idPessoa
     * @param nomePessoa
     * @return String com o resultado da operacao
     * @throws Excecao
     * @deprecated
     */
    public String atualizarPessoa(int idPessoa, String nomePessoa) throws Excecao{

        String sql = "UPDATE T_AM_SCN_PESSOA SET CD_PESSOA = ? WHERE CD_PESSOA = ?";

        try{
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, idPessoa);
            ps.setString(2, nomePessoa);
            ps.executeUpdate();
            ps.close();
            return "Registro atualizado com sucesso";
        }catch (SQLException e){
            throw new Excecao(e);
        }
    }

    /**
     * Metodo para deletar pessoa do banco de dados
     * @param idPessoa
     * @return int com o numero de linhas afetadas
     * @throws Excecao
     * @deprecated
     */
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

    /**
     * Metodo para buscar Pessoa no banco de Dados utilizando o codigo
     * @param codigo - Codigo da Pessoa
     * @return Objeto pessoa
     * @throws Excecao
     */
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

    /**
     * Busca a pessoa no banco de dados pelo nome da Pessoa
     * @param pNome - Nome da Pessoa
     * @return Objeto Pessoa
     * @throws Excecao
     */
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
