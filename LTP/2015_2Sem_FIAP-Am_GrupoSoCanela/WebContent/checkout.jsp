<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>Hotel Boa Viagem</title>
<head>
  <meta charset="utf-8">
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/bootstrap-theme.min.css" rel="stylesheet">
  <link rel="stylesheet" href="css/style.css">
  <script src="js/jquery-2.1.4.min.js"></script>
  <script src="js/jquery.maskMoney.min.js"></script>
  <script src="js/jquery.mask.min.js"></script>
  <script src="js/script.js"></script>
</head>
<body>
  <nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <a class="navbar-brand" href="#">Hotel Boa Viagem</a>
      </div>
      <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav">
          <li><a href="checkin.jsp">Check In</a></li>
          <li class="active"><a href="checkout.jsp">Check Out</a></li>
        </ul>
      </div>
    </div>
  </nav>

  <div class="container">
    <div class="jumbotron main-container" id="hbv-container">
      <legend><h3>Check Out</h3></legend>
      <form action="checkout" method="post">
        <div class="form-group mTop20">
          <div class="row">
            <div class="col-md-4">
              <label for="cd_reserva">Código da hospedagem</label>
              <input class="form-control" id="cd_reserva" name="cd_reserva" placeholder="Insira o código da reserva" type="number"/>
            </div>
            <div class="col-md-4 mTop20">
              <input type="submit" value="Buscar" class="btn btn-primary raised">
            </div>
          </div>

          <br>
          <h4 class="mTop20">Informações do cliente</h4>
          <div class="row">
            <div class="col-md-4">
              <label for="cpf">CPF</label>
              <input class="form-control" id="cpf" name="cpf" placeholder="999.999.999-99" value="${hospedagem.cliente.cpf}"/>
            </div>
            <div class="col-md-4">
              <label for="name">Nome</label>
              <input class="form-control" id="name" name="nome" placeholder="Nome do cliente" value="${hospedagem.cliente.nome}"/>
            </div>
          </div>
        </div>

        <br>
        <h4>Informações da hospedagem</h4>
        <div class="row mTop20">
          <div class="col-md-3">
            <label for="nr_quarto">Nº do quarto</label>
            <input class="form-control" id="nr_quarto" name="nr_quarto" placeholder="Nº" type="number" value="${hospedagem.nrQuarto}"/>
          </div>
          <div class="col-md-3">
            <label for="dt_entrada">Data de entrada</label>
            <input class="form-control" id="dt_entrada" name="dt_entrada" placeholder="99/99/9999" value="${hospedagem.dtEntrada}" />
          </div>
          <div class="col-md-3">
            <label for="dt_saida">Data saída</label>
            <input class="form-control" id="dt_saida" name="dt_saida" placeholder="99/99/9999" value="${hospedagem.dtSaida}" />
          </div>
          <div class="col-md-3">
            <label for="perc_desconto">Percentual de desconto</label>
            <input class="form-control" id="perc_desconto" name="perc_desconto" placeholder="Percentual" type="number" value="${empty hospedagem.percDesconto ? 0 : hospedagem.percDesconto}" />
          </div>
        </div>

        <br>
        <h4 class="mTop20">Informações de pagamento</h4>
        <div class="form-group mTop20">
          <div class="row">
            <div class="col-md-4">
              <label for="cd_tipo_pagamento">Forma de pagamento</label>
              <select class="form-control" id="cd_tipo_pagamento" name="cd_tipo_pagamento">
                  <option>Selecione</option>
                  <option value="1">Dinheiro</option>
                  <option value="2">Cartão</option>
                  <option value="3">Cheque</option>
              </select>
            </div>
            <div class="col-md-4">
              <label for="vl_pagamento">Valor Total</label>
              <input class="form-control" id="vl_pagamento" name="vl_pagamento" placeholder="Valor total" />
            </div>
          </div>
        </div>
        <div class="row mTop20">
          <div class="col-lg-3 mTop20">
            <input type="hidden" value="1" name="cd_funcionario">
            <input type="submit" value="Realizar Check Out" class="btn btn-primary raised">
          </div>
          <div class="col-lg-6 mTop20">
            <input type="reset" value="Limpar campos" class="btn btn-danger raised" id="clear-form">
          </div>
        </div>
      </form>
    </div>
  </div>
</body>