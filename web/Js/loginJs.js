$(document).ready(function () {
    $(".mensajeError").css("height", "0");

    $("#IngresoLog").click(function () {
        $.ajax({url: contexto + "/ControlLogin?username=" + $("#username").val() + "&password=" + $("#password").val(),
            method: "GET",
            success: function (result) {
                if (result == true || result == "true") {
                    $(".mensajeError").animate({
                        height: '30px'
                    }, function () {
                        setTimeout(function () {
                            $(".mensajeError").animate({
                                height: '0'
                            });
                        },5000);
                    });
                } else {
                    window.location = contexto + "/Jsp/menu.jsp";
                }
            }});
    });
});


