package br.com.fiap.am.scn.bo;

import br.com.fiap.am.scn.beans.*;
import br.com.fiap.am.scn.dao.ConsumoDAO;
import br.com.fiap.am.scn.dao.HospedagemDAO;
import br.com.fiap.am.scn.dao.PagamentoDAO;
import br.com.fiap.am.scn.dao.QuartoDAO;
import br.com.fiap.am.scn.exception.Excecao;

import java.util.List;

/**
 * Created by
 *
 * @author vinylimaz
 *         on 26/10/15 & 19:43.
 *         PagamentoBO é uma classe
 */
public class PagamentoBO {

    public String confPagamento(Pagamento pagamento) throws Excecao{

        //Dia do pagamento é o dia de hoje
        pagamento.setDtPagamento(new HospedagemDAO().sysDate());
        pagamento.setValor(valorTotal(pagamento.getCodHospedagem().getCliente()));
        return new PagamentoDAO().confPagamento(pagamento);
    }

    public double valorTotal(Cliente cliente) throws Excecao{
        return valorHosp(cliente) + valorProd(cliente) + valorServ(cliente);
    }


    public double valorProd(Cliente cliente) throws Excecao{
        double valorProd = 0;
        Hospedagem hospedagem = new HospedagemDAO().getHospedagem(cliente);
        List<Consumo> produto = new ConsumoDAO().getProduto(hospedagem.getCodHospedagem());
        for (Consumo prod : produto) {
            valorProd += prod.getHistoricoPreco().getVlPreco() * prod.getQtdeConsumo();
        }
        return valorProd;
    }

    public double valorServ(Cliente cliente) throws Excecao{
        Hospedagem hospedagem = new HospedagemDAO().getHospedagem(cliente);
        double valorServ = 0;
        List<Consumo> servico = new ConsumoDAO().getServico(hospedagem.getCodHospedagem());

        for (Consumo serv : servico) {
            valorServ += serv.getHistoricoPreco().getVlPreco() * serv.getQtdeConsumo();
        }
        return valorServ;
    }

    public double valorHosp(Cliente cliente) throws Excecao{
        double valorHosp = 0;
        Hospedagem hospedagem = new HospedagemDAO().getHospedagem(cliente);

        List<ReservaQuarto> quartos = new QuartoDAO().getQuartos(hospedagem.getReserva().getCodReserva());
        //TODO como verificar a validade dos valores em relaçao ao pgto?
        for (ReservaQuarto reservaQuarto : quartos) {
            Quarto quarto = reservaQuarto.getQuarto();
            valorHosp += (quarto.getValorQuarto().getVl_preco_quarto());
        }
        return valorHosp;
    }
}
