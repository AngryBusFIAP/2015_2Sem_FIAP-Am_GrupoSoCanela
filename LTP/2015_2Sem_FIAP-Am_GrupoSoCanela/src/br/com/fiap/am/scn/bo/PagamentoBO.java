package br.com.fiap.am.scn.bo;

import java.util.List;

import br.com.fiap.am.scn.beans.Cliente;
import br.com.fiap.am.scn.beans.Consumo;
import br.com.fiap.am.scn.beans.Hospedagem;
import br.com.fiap.am.scn.beans.Pagamento;
import br.com.fiap.am.scn.beans.Quarto;
import br.com.fiap.am.scn.beans.ReservaQuarto;
import br.com.fiap.am.scn.dao.ConsumoDAO;
import br.com.fiap.am.scn.dao.HospedagemDAO;
import br.com.fiap.am.scn.dao.PagamentoDAO;
import br.com.fiap.am.scn.dao.QuartoDAO;
import br.com.fiap.am.scn.exception.Excecao;

/**
 * Classe de Regra de negocio do pagamento
 * @see {@link br.com.fiap.am.scn.beans.Pagamento}
 */
public class PagamentoBO {

	/**
	 * Confere o pagamento utilizando o objeto pagamento
	 * @param pagamento - Objeto Pagamento
	 * @return String com o resultado
	 * @throws Excecao
	 */
    public String confPagamento(Pagamento pagamento) throws Excecao{
        //Dia do pagamento e o dia de hoje
        pagamento.setDtPagamento(new HospedagemDAO().sysDate());
        pagamento.setValor(valorTotal(pagamento.getCodHospedagem().getCliente()));
        return new PagamentoDAO().confPagamento(pagamento);
    }

    /**
     * metodo que calcula o valor da hospedagem, valor dos produtos, valor do servicos
     * e soma tudo ao total
     * @param cliente - Objeto Cliente
     * @return double com o valor total a ser pago
     * @throws Excecao
     */
    public double valorTotal(Cliente cliente) throws Excecao{
        return valorHosp(cliente) + valorProd(cliente) + valorServ(cliente) * 0.95;
    }

    /**
     * metodo para calcular pro valor dos produtos consumidos utilizando o objeto Cliente
     * @param cliente - Objeto Cliente
     * @return double com o valor dos produtos consumidos
     * @throws Excecao
     */
    public double valorProd(Cliente cliente) throws Excecao{
        double valorProd = 0;
        Hospedagem hospedagem = new HospedagemDAO().getHospedagem(cliente);
        List<Consumo> produto = new ConsumoDAO().getProduto(hospedagem.getCodHospedagem());
        for (Consumo prod : produto) {
            valorProd += prod.getHistoricoPreco().getVlPreco() * prod.getQtdeConsumo();
        }
        return valorProd;
    }

    /**
     * Metodo para calcular os valor dos servicos usados utilizando os Clientes
     * @param cliente - Objeto Cliente
     * @return double com o valor dos Servicos usados
     * @throws Excecao
     */
    public double valorServ(Cliente cliente) throws Excecao{
        Hospedagem hospedagem = new HospedagemDAO().getHospedagem(cliente);
        double valorServ = 0;
        List<Consumo> servico = new ConsumoDAO().getServico(hospedagem.getCodHospedagem());

        for (Consumo serv : servico) {
            valorServ += serv.getHistoricoPreco().getVlPreco() * serv.getQtdeConsumo();
        }
        return valorServ;
    }
    
    /**
     * metodo para calcular o valor da Hospedagem utilizando o Objeto Cliente
     * @param cliente - Objeto Cliente
     * @return double com o valor da hospedagem
     * @throws Excecao
     */
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
