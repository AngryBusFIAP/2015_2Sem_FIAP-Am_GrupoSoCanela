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
        <div class="row mTop20">
          <div class="col-lg-3 mTop20">
            <input type="hidden" value="checkout" name="veioDe">
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