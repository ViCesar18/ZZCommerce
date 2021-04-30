<%--
  Created by IntelliJ IDEA.
  User: vnces
  Date: 17/12/2020
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/assets/css/main.css">
        <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
        <title>Página Inicial</title>
    </head>
    <body>
        <div class="main-container">
            <header>
                <a href="${pageContext.servletContext.contextPath}/allProduto">
                    <img src="${pageContext.servletContext.contextPath}/assets/img/zz-logo.png">
                </a>
                <span><strong>Olá, ${loggedInUser.username}!</strong></span>

                <a type="button" class="anunciar" href="${pageContext.servletContext.contextPath}/view/produto/register.jsp">Anunciar um Produto</a>
                <a type="button" class="rect-button" id="cart" href="#">
                    <i class="fas fa-shopping-cart" style="color: limegreen"></i>
                </a>
                <a type="button" class="rect-button" id="logoff" href="#">
                    <i class="fas fa-power-off" style="color: #F57000"></i>
                </a>
            </header>

            <div class="barra-pesquisa">
                <h1>Encontre seu produto</h1>
                <form
                        class="form"
                        action="${pageContext.servletContext.contextPath}/pesquisa"
                        method="post"
                >
                    <input type="text" placeholder="Procure produtos de seu interesse..." required class="form-control" id="inputPesquisa" name="pesquisa">
                    <button type="submit">Pesquisar</button>
                </form>
            </div>

            <ul>
                <c:forEach var="produto" items="${requestScope.produtos}">
                    <li>
                        <img src="${pageContext.request.contextPath}/assets/img/${produto.imagem != null ? produto.imagem : "default-product-image.png"}">
                        <strong class="titulo-produto">${produto.nome}</strong>
                        <p><strong>Vinícius Cesar</strong></p>
                        <p>R$${produto.precoVenda}</p>
                        <a type="button" style="background-color: limegreen; margin-bottom: 5px" href="#">
                            <i class="fas fa-shopping-cart" style="color: white; margin-right: 5px"></i>
                            Carrinho
                        </a>
                        <a type="button" href="#">Ver Produto</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </body>
</html>
