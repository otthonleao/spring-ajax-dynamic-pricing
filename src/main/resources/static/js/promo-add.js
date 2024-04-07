$(" #linkPromocao ").on('change', function() {
    var url = $(this).val();
    if (url.length > 7) {
        $.ajax({
            method: "POST",
            url: "/meta/info?url=" + url,
            cache: false,
            success: function (data) {
                console.log(data);
                $("#titulo").val(data.title);
                $("#site").text(data.site.replace("@", ""));
                $("#linkImagem").attr("src", data.image);
            },
            statusCode: {
                404: function () {
                    $("#alert").addClass("alert alert-danger").text("Nenuma informação pode ser recuperada desta URL")
                },
                error: function () {
                    $("#alert").addClass("alert alert-danger").text("Erro 500: Algo deu errado, tente novamente mais tarde")
                }
            }
        })
    }
})