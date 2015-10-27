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
          <li class="active"><a href="#checkin">Check In</a></li>
          <li><a href="checkout.html">Check Out</a></li>
        </ul>
      </div>
    </div>
  </nav>

  <div class="container">
    <div class="jumbotron main-container" id="hbv-container">
      <legend><h3>Check In</h3></legend>
      <form action="checkin" method="post">
        <h4>Informações da reserva</h4>
        <div class="form-group mTop20">
          <div class="row">
            <div class="col-md-4">
              <label for="cd_reserva">Código da reserva</label>
              <input class="form-control" id="cd_reserva" name="cd_reserva" placeholder="Insira o código da reserva" type="number" />
            </div>
          </div>
          <div class="row mTop20">
            <div class="col-md-4">
              <label for="dt_solicitacao">Data solicitação</label>
              <input class="form-control" id="dt_solicitacao" name="dt_solicitacao" placeholder="99/99/9999" />
            </div>
            <div class="col-md-4">
              <label for="dt_inicio">Data início</label>
              <input class="form-control" id="dt_inicio" name="dt_inicio" placeholder="99/99/9999" />
            </div>
            <div class="col-md-4">
              <label for="dt_final">Data final</label>
              <input class="form-control" id="dt_final" name="dt_final" placeholder="99/99/9999" />
            </div>
          </div>
          <div class="row mTop20">
            <div class="col-md-4">
              <label for="qt_adulto">Quantidade de adultos</label>
              <input class="form-control" id="qt_adulto" name="qt_adulto" placeholder="Qtde de adultos" type="number" />
            </div>
            <div class="col-md-4">
              <label for="qt_crianca">Quantidade de crianças</label>
              <input class="form-control" id="qt_crianca" name="qt_crianca" placeholder="Qtde de crianças" type="number" />
            </div>
            <div class="col-md-4">
              <label for="st_reserva">Status da reserva</label>
              <select class="form-control" id="st_reserva" name="st_reserva">
                <option>Selecione o status</option>
              </select>
            </div>
          </div>
        </div>

        <br>
        <h4 class="mTop20">Informações do quarto</h4>
        <div class="form-group mTop20">
          <div class="row">
            <div class="col-md-4">
              <label for="cd_tipo_quarto">Tipo do quarto</label>
              <select class="form-control" id="cd_tipo_quarto" name="cd_tipo_quarto">
                <option>Selecione o tipo de quarto</option>
                <option value="1">Single</option>
                <option value="2">Double</option>
                <option value="3">Suíte de Luxo</option>
                <option value="4">Suíte presidencial</option>
              </select>
            </div>
            <div class="col-md-4">
              <label for="nr_andar">Nº andar</label>
              <input class="form-control" id="nr_andar" name="nr_andar" placeholder="Nº andar" type="number" />
            </div>
            <div class="col-md-4">
              <label for="nr_capacidade">Capacidade de pessoas</label>
              <input class="form-control" id="nr_capacidade" name="nr_capacidade" placeholder="Capacidade" type="number" />
            </div>
          </div>
        </div>

        <br>
        <h4 class="mTop20">Informações do cliente</h4>
        <div class="form-group mTop20">
          <div class="row">
            <div class="col-md-4">
              <label for="cpf">CPF</label>
              <input class="form-control" id="cpf" name="cpf" placeholder="999.999.999-99"/>
            </div>
            <div class="col-md-4">
              <label for="name">Nome</label>
              <input class="form-control" id="name" name="nome" placeholder="Nome do cliente"/>
            </div>
            <div class="col-md-4">
              <label for="rg">RG</label>
              <input class="form-control" id="rg" name="rg" placeholder="RG do cliente"/>
            </div>
          </div>
          <div class="row mTop20">
            <div class="col-md-4">
              <label for="dt_nascimento">Data de nascimento</label>
              <input class="form-control" id="birthday" name="dt_nascimento" placeholder="99/99/9999" />
            </div>
            <div class="col-md-4">
              <label for="nr_quarto_preferido">Nº quarto preferido</label>
              <input class="form-control" id="nr_quarto_preferido" name="nr_quarto_preferido" placeholder="Nº quarto preferido" type="number" />
            </div>
          </div>
        </div>
        <div class="row mTop20">
          <div class="col-lg-3 mTop20">
            <input type="hidden" value="checkin" name="veioDe">
            <input type="submit" value="Realizar Check In" class="btn btn-primary raised">
          </div>
          <div class="col-lg-6 mTop20">
            <input type="reset" value="Limpar campos" class="btn btn-danger raised" id="clear-form">
          </div>
        </div>
      </form>
    </div>
  </div>
</body>