package br.com.fiap.am.scn.dao;

import br.com.fiap.am.scn.beans.Cliente;
import br.com.fiap.am.scn.beans.Pessoa;
import br.com.fiap.am.scn.connection.ConexaoFactory;
import br.com.fiap.am.scn.exception.Excecao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Jardel on 20/10/2015.
 */
public class ClienteDAO {

    private Connection c;

    public ClienteDAO() throws Excecao{
        try{
            c = new ConexaoFactory().getConnection();
        }catch(Exception e){
            throw new Excecao(e);
        }
    }

    public String cadastrarCliente(Pessoa pessoa, Cliente cliente) throws Excecao{

        String sql = "INSERT INTO T_AM_SCN_PESSOA VALUES (SQ_SCN_PESSOA.NEXTVAL, ?)";

        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, pessoa.getNome());
            ps.execute();

        } catch (SQLException e) {
            throw new Excecao(e);

        }

        String sql2 = "INSERT INTO T_AM_SCN_CLIENTE VALUES (SQ_SCN_PESSOA.CURRVAL, ?,?,?,?,?,?)";

        try{
            PreparedStatement ps = c.prepareStatement(sql2);
            ps.setLong(1, cliente.getCpf());
            ps.setString(2, cliente.getRg());
            ps.setString(3, cliente.getDtNascimento());
            ps.setInt(4, cliente.getQuartoPreferido());
            ps.setString(5, cliente.getEmail());
            ps.setString(6, cliente.getSenha());
            ps.execute();
            ps.close();
        }catch(SQLException e){
            throw  new Excecao(e);
        }
        return "Registro inserido com sucesso";
    }

    public Cliente getCliente(int codigo) throws Excecao{

        Cliente cliente = new Cliente();

        try {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM T_AM_SCN_CLIENTE WHERE CD_CLIENTE = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cliente.setId(rs.getInt("CD_CLIENTE"));
                cliente.setCpf(rs.getLong("NR_CPF"));
                cliente.setRg(rs.getString("NR_RG"));
                cliente.setDtNascimento(rs.getString("DT_NASCIMENTO"));
                cliente.setQuartoPreferido(rs.getInt("NR_QUARTO_PREFERIDO"));
                cliente.setEmail(rs.getString("DS_EMAIL"));
                cliente.setSenha(rs.getString("DS_SENHA"));
            }
            rs.close();
            ps.close();
        }catch(SQLException e){
            throw new Excecao(e);
        }

        return cliente;
    }

    public Cliente getClienteCPF(long cpf) throws Excecao{

        Cliente cliente = new Cliente();

        try {
            PreparedStatement ps = c.prepareStatement("SELECT * FROM T_AM_SCN_CLIENTE WHERE NR_CPF = ?");
            ps.setLong(1, cpf);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cliente.setCpf(rs.getLong("NR_CPF"));
                cliente.setRg(rs.getString("NR_RG"));
                cliente.setDtNascimento(rs.getString("DT_NASCIMENTO"));
                cliente.setQuartoPreferido(rs.getInt("NR_QUARTO_PREFERIDO"));
                cliente.setEmail(rs.getString("DS_EMAIL"));
                cliente.setSenha(rs.getString("DS_SENHA"));
            }
            rs.close();
            ps.close();
        }catch(SQLException e){
            throw new Excecao(e);
        }

        return cliente;
    }


}
