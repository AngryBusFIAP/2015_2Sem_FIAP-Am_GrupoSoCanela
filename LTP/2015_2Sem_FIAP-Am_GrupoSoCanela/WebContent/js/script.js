$(document).ready(function(){

    $("#cpf").mask("000.000.000-00");
    $("#birthday").mask("00/00/0000");
    $("#dt_solicitacao").mask("00/00/0000");
    $("#dt_inicio").mask("00/00/0000");
    $("#dt_final").mask("00/00/0000");
    $("#dt_entrada").mask("00/00/0000");
    $("#dt_saida").mask("00/00/0000");
    $("#vl_pagamento").maskMoney({
        prefix: "R$ ",
        thousands: '.',
        decimal: ','
    });

    $("#clear-form").on('click', function(){ $("#cd_reserva").focus(); })

    $("#btnConf").click(function(){
        $("#metodo").val("confirmar");
    });
});