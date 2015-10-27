package br.com.fiap.am.scn.dao;

import br.com.fiap.am.scn.beans.*;
import br.com.fiap.am.scn.connection.ConexaoFactory;
import br.com.fiap.am.scn.exception.Excecao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by
 *
 * @author vinylimaz
 *         on 20/10/15 & 20:20.
 *         HospedagemDAO é uma classe
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

    public String confirmHosp(Cliente cliente, Hospedagem hospedagem, Quarto quarto, Reserva reserva, Funcionario funcionario) {
        return null;
    }

    public Date sysDate() throws Excecao {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT SYSDATE FROM DUAL");
            ResultSet resultSet = stmt.executeQuery();

            if(resultSet.next()) {
                Date sysDt = dateFormat.parse(resultSet.getString("SYSDATE"));
                return sysDt;
            }else{
                return new Date();
            }
        } catch (Exception e) {
            throw new Excecao(e);
        }
    }


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

    public Hospedagem getHospedagem(int codigo) throws Excecao {

        Hospedagem hospedagem = new Hospedagem();
        Quarto quarto = new Quarto();
        Cliente cliente = new Cliente();
        Funcionario funcionario = new Funcionario();
        Reserva reserva = new Reserva();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM T_AM_SCN_HOSPEDAGEM WHERE CD_HOSPEDAGEM =?");
            ps.setInt(1, codigo);
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


}
