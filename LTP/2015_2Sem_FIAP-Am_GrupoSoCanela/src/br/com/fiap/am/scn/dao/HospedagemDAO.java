package br.com.fiap.am.scn.dao;

import br.com.fiap.am.scn.beans.*;
import br.com.fiap.am.scn.connection.ConexaoFactory;
import br.com.fiap.am.scn.exception.Excecao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 * Classe de acesso de dados de Hospedagem
 */
public class HospedagemDAO {
    private Connection connection;

    public HospedagemDAO() throws Excecao {
        try {
            connection = new ConexaoFactory().getConnection();
        } catch (Exception e) {
            throw new Excecao(e);
        }
    }
    /**
     * Metodo que retorna a data atual do sistema utilizando 
     * uma consulta no banco de dados
     * @return String com a data do sistema
     * @throws Excecao
     */
    public String sysDate() throws Excecao {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT SYSDATE FROM DUAL");
            ResultSet resultSet = stmt.executeQuery();

            if(resultSet.next()) {
                String sysDt = resultSet.getString("SYSDATE");
                return sysDt;
            }else{
                return null;
            }
        } catch (Exception e) {
            throw new Excecao(e);
        }
    }

    /**
     * Metodo para Cadastrar a hospedagem 
     * Utilizando prepared statement
     * @param hospedagem
     * @return String confirmando se foi cadastrado ou nao
     * @throws Excecao
     */
    public String confirmHosp(Hospedagem hospedagem) throws Excecao{

        String sql = "INSERT INTO T_AM_SCN_HOSPEDAGEM VALUES (SQ_SCN_HBV_HOSPEDAGEM.NEXTVAL, ?,?,?,?,?,?,?)";

        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, hospedagem.getQuarto().getNumero());
            ps.setInt(2, hospedagem.getReserva().getCodReserva());
            ps.setInt(3, hospedagem.getCliente().getId());
            ps.setInt(4, hospedagem.getFuncionario().getId());
            ps.setString(5, hospedagem.getDtEntrada());
            ps.setString(6, hospedagem.getDtSaida());
            ps.setDouble(7, hospedagem.getPercDesconto());
            ps.execute();
            ps.close();
        }catch (SQLException e){
            throw new Excecao(e);
        }

        return "Hospedagem cadastrada com sucesso";
    }

    /**
     * Busca a hospedagem pelo Codigo da Hospedagem
     * @param codHospedagem
     * @return Objeto Hospedagem
     * @throws Excecao
     */
    public Hospedagem getHospedagem(int codHospedagem) throws Excecao {

        Hospedagem hospedagem = new Hospedagem();
        Quarto quarto = new Quarto();
        Cliente cliente = new Cliente();
        Funcionario funcionario = new Funcionario();
        Reserva reserva = new Reserva();
        Pagamento pagamento = new Pagamento();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT H.CD_HOSPEDAGEM, Q.NR_QUARTO, R.CD_RESERVA, C.CD_CLIENTE, "
                    + "P.NM_PESSOA, C.NR_CPF, C.NR_RG, C.DT_NASCIMENTO, H.DT_ENTRADA, H.DT_SAIDA, H.VC_PERC_DESCONTO, PAG.VL_PAGAMENTO "
                    + "FROM T_AM_SCN_HOSPEDAGEM H "
                    + "JOIN T_AM_SCN_QUARTO Q ON Q.NR_QUARTO = H.NR_QUARTO "
                    + "JOIN T_AM_SCN_RESERVA R ON R.CD_RESERVA = H.CD_RESERVA "
                    + "JOIN T_AM_SCN_CLIENTE C ON C.CD_CLIENTE = H.CD_CLIENTE "
                    + "JOIN T_AM_SCN_PESSOA P ON P.CD_PESSOA = C.CD_CLIENTE "
                    + "JOIN T_AM_SCN_PAGAMENTO PAG ON PAG.CD_HOSPEDAGEM = H.CD_HOSPEDAGEM "
                    + " WHERE H.CD_HOSPEDAGEM = ?");
            ps.setInt(1, codHospedagem);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                hospedagem.setCodHospedagem(rs.getInt("CD_HOSPEDAGEM"));
                quarto.setNumero(rs.getInt("NR_QUARTO"));
                reserva.setCodReserva(rs.getInt("CD_RESERVA"));
                cliente.setId(rs.getInt("CD_CLIENTE"));
                cliente.setNome(rs.getString("NM_PESSOA"));
                cliente.setCpf(rs.getLong("NR_CPF"));
                cliente.setRg(rs.getString("NR_RG"));
                cliente.setDtNascimento(rs.getString("DT_NASCIMENTO"));
               // funcionario.setId(rs.getInt("CD_FUNCIONARIO"));
                hospedagem.setDtEntrada(rs.getString("DT_ENTRADA"));
                hospedagem.setDtSaida(rs.getString("DT_SAIDA"));
                hospedagem.setPercDesconto(rs.getDouble("VC_PERC_DESCONTO"));
                pagamento.setValor(rs.getDouble("VL_PAGAMENTO"));
                hospedagem.setPagamento(pagamento);
                hospedagem.setQuarto(quarto);
                hospedagem.setReserva(reserva);
                hospedagem.setCliente(cliente);
                hospedagem.setFuncionario(funcionario);
                rs.close();
                ps.close();
            }
        } catch (SQLException e) {
            throw new Excecao(e);
        }
        return hospedagem;
    }
    /**
     * Busca a hospedagem utilizando o objeto Cliente
     * @param cliente
     * @return Objeto Hospedagem
     * @throws Excecao
     */
    public Hospedagem getHospedagem(Cliente cliente) throws Excecao {

        Hospedagem hospedagem = new Hospedagem();
        Quarto quarto = new Quarto();
        Funcionario funcionario = new Funcionario();
        Reserva reserva = new Reserva();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM T_AM_SCN_HOSPEDAGEM WHERE CD_CLIENTE = ?");
            ps.setInt(1, cliente.getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                hospedagem.setCodHospedagem(rs.getInt("CD_HOSPEDAGEM"));
                quarto.setNumero(rs.getInt("NR_QUARTO"));
                reserva.setCodReserva(rs.getInt("CD_RESERVA"));
                cliente.setId(rs.getInt("CD_CLIENTE"));
                funcionario.setId(rs.getInt("CD_FUNCIONARIO"));
                hospedagem.setDtEntrada(rs.getString("DT_ENTRADA"));
                hospedagem.setDtSaida(rs.getString("DT_SAIDA"));
                hospedagem.setPercDesconto(rs.getDouble("VC_PERC_DESCONTO"));
                hospedagem.setQuarto(quarto);
                hospedagem.setReserva(reserva);
                hospedagem.setCliente(cliente);
                hospedagem.setFuncionario(funcionario);
                rs.close();
                ps.close();
            }
        } catch (SQLException e) {
            throw new Excecao(e);
        }
        return hospedagem;
    }

    public double valorHospedagem(Hospedagem hospedagem){


        return 1.1;
    }
}
