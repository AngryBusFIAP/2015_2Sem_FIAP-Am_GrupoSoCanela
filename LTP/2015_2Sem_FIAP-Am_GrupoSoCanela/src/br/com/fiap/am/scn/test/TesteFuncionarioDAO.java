package br.com.fiap.am.scn.test;

import br.com.fiap.am.scn.beans.Funcionario;
import br.com.fiap.am.scn.dao.FuncionarioDAO;
import br.com.fiap.am.scn.exception.Excecao;

/**
 * Created by Jardel on 20/10/2015.
 */
public class TesteFuncionarioDAO {

    public static void main(String[] args)throws Excecao{

        Funcionario f = new Funcionario();
        FuncionarioDAO fDAO = new FuncionarioDAO();
        f = fDAO.getFuncionario(9);
        System.out.println(f.getCargo() + "\n" + f.getDtAdmissao());

    }
}
