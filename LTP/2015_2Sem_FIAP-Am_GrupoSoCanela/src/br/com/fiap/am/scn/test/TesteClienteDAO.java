package br.com.fiap.am.scn.test;

import br.com.fiap.am.scn.beans.Cliente;
import br.com.fiap.am.scn.beans.Pessoa;
import br.com.fiap.am.scn.dao.ClienteDAO;
import br.com.fiap.am.scn.dao.PessoaDAO;
import br.com.fiap.am.scn.exception.Excecao;

/**
 * Created by Jardel on 20/10/2015.
 */
public class TesteClienteDAO {

    public static void main(String[] args) throws Excecao{
        Pessoa p = new Pessoa();
       Cliente c = new Cliente();
        p.setNome("DIFERENTEPORRA");
        c.setCpf(4255252345l);
        c.setRg("42849901");
        c.setDtNascimento("28/12/1993");
        c.setQuartoPreferido(10);
       c.setEmail("J4rdellrocha@msn.com");
       c.setSenha("test123");
//
//
        System.out.println(new ClienteDAO().cadastrarCliente(p, c));
//        Pessoa p = new Pessoa();
//        PessoaDAO pDAO = new PessoaDAO();
//        p = pDAO.getPessoa(1);
//        Cliente c = new Cliente();
//        ClienteDAO cliDAO = new ClienteDAO();
//        c = cliDAO.getClienteCPF(34891612601l);
//        System.out.println(p.getNome() + "\n" +  c.getCpf());
    }
}
