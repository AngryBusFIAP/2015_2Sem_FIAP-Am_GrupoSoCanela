$(document).ready(function(){

  $("#cpf").mask("000.000.000-00");
  $("#birthday").mask("00/00/0000");
  $("#dt_solicitacao").mask("00/00/0000");
  $("#dt_inicio").mask("00/00/0000");
  $("#dt_final").mask("00/00/0000");

  $("#clear-form").on('click', function(){ $("#cd_reserva").focus(); })

  $("#cd_reserva").on('focusout', function(){
    var cd_reserva = this.value;
    // todo create a ajax request to get all informations
  })

    $("#btnConf").click(function(){
        $("#metodo").val("confirmar");
        alert($("#metodo").val());

    })
});

//function confirmCheckin(){
//    document.getElementById("metodo").value = "confirmar";
//}