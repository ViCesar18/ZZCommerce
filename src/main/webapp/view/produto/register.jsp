<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="../../assets/css/anunciar-produto.css">
        <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
        <title>Anunciar Produto</title>
    </head>
    <body>
        <div class="register-product-container">
            <div class="content">
                <section>
                    <image src="../../assets/img/zz-logo.png"/>
                    <h1>Anuncie um produto!</h1>
                    <p>Cadastre um produto e aguarde alguém interessado entrar em contato!</p>
                    <div>
                        <i class="fas fa-arrow-left" style="color: #2C88D9"></i>
                        <a type="button" href="${pageContext.servletContext.contextPath}/view/main_page.jsp">Voltar para Home</a>
                    </div>
                </section>
                <form
                        class="form"
                        action="${pageContext.servletContext.contextPath}/registerProduto"
                        method="post"
                >
                    <div class="form-group">
                        <input type="text" placeholder="Nome" required class="form-control" id="inputNome" name="nome">
                    </div>

                    <div class="form-group">
                        <input type="number" step="0.01" placeholder="Preço" required class="form-control" id="inputPreco" name="preco">
                    </div>

                    <div class="form-group">
                        <input type="number" placeholder="Quantidade" required class="form-control" id="inputQuantidade" name="quantidade">
                    </div>

                    <div class="buttons">
                        <button type="submit" class="btn btn-primary">Adicionar Produto</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>