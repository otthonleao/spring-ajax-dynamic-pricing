// SUBMIT DO FORMULARIO PARA O CONTROLLER
$("#form-add-promo").submit(function(evt) {
    evt.preventDefault(); //bloqueia comportamento padrão do submit

    let promo = {};
    promo.linkPromocao = $("#linkPromocao").val();
    promo.descricao = $("#descricao").val();
    promo.preco = $("#preco-").val();
    promo.titulo = $("#titulo").val();
    promo.categoria = $("#categoria").val();
    promo.linkImagem = $("#linkImagem").val();
    promo.site = $("#site").text();

    console.log("promo > ", promo);

    $.ajax({
        method: "POST",
        url: "/promocao/save",
        data: promo,
        beforeSend: function () {
            // Remover as mensagens de erro
            $("#span").closest('.error-span').remove();
            // Remover as bordas vermelhas dos inputs
            $("#categoria").removeClass("is-invalid");
            $("#preco").removeClass("is-invalid");
            $("#linkPromocao").removeClass("is-invalid");
            $("#titulo").removeClass("is-invalid");
            // Habilita o loading na página
            $("#form-add-promo").hide();
            $("#loader-form").addClass("loader").show();
        },
        success: function () {
            $("#form-add-promo").each(function () {
                this.reset();
            });
            $("#linkImagem").attr("scr", "/images/promo-dark.png");
            $("#site").text("");
            $("#alert")
                .removeClass("alert alert-danger")
                .addClass("alert alert-success")
                .text("OK! Promoção cadastrada com sucesso!");
        },
        error: function (xhr) {
            console.log("> ERROR: " + xhr.responseText);
            $("#alert").addClass("alert alert-danger").text("Não foi possível salvar esta promoção.");
        },
        complete: function () {
            $("#loader-form").fadeOut(800, function() {
                $("#form-add-promo").fadeIn(250);
                $("#loader-form").removeClass("loader");
            });
        }
    });
});

$(" #linkPromocao ").on('change', function() {
    var url = $(this).val();
    if (url.length > 7) {
        $.ajax({
            method: "POST",
            url: "/meta/info?url=" + url,
            cache: false,
            beforeSend: function() {
                $("#alert").removeClass("alert alert-danger alert-sucess").text("");
                $("#titulo").val("");
                $("#site").text("");
                $("#linkImagem").attr("src", "");
                $("#loader-img").addClass("loader");
            },
            success: function (data) {
                console.log(data);
                $("#titulo").val(data.title);
                $("#site").text(data.site.replace("@", ""));
                $("#linkImagem").attr("src", data.image);
            },
            statusCode: {
                404: function () {
                    $("#alert").addClass("alert alert-danger").text("Nenuma informação pode ser recuperada desta URL")
                    $("#linkImagem").attr("src", "/images/promo-dark.png");
                },
                error: function () {
                    $("#alert").addClass("alert alert-danger").text("Erro 500: Algo deu errado, tente novamente mais tarde")
                    $("#linkImagem").attr("src", "/images/promo-dark.png");
                }
            },
            complete: function () {
                $("#loader-img").removeClass("loader");
            }
        });
    }
});