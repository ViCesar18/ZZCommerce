<%--
  Created by IntelliJ IDEA.
  User: vnces
  Date: 17/12/2020
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Página Inicial</title>
</head>
<body>
    <h1>ZZCommerce!</h1>
    <a type="button" class="btn btn-danger" href="${pageContext.servletContext.contextPath}/view/produto/register.jsp">Adicionar um Produto</a>

    <div class="container">
        <p><strong>Encontre seu produto</strong></p>
        <form
                class="form"
                action="${pageContext.servletContext.contextPath}/pesquisa"
                method="post"
        >
            <div class="form-group">
                <input type="text" required class="form-control" id="inputPesquisa" name="pesquisa">
            </div>
            <button type="submit" class="btn btn-primary">Pesquisar</button>
        </form>
    </div>
    <div class="container">
        <table class="table table-striped">
            <thead>
            <tr>
                <th class="col h4">ID</th>
                <th class="col h4">Nome</th>
                <th class="col h4">Preço</th>
                <th class="col h4">Quantidade disponível</th>
                <th class="col h4">Anunciante</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="produto" items="${requestScope.produtos}">
                <tr>
                    <td>
                        <span class="h4"><c:out value="${produto.id}"/></span>
                    </td>

                    <td>
                        <p class="h4"><c:out value="${produto.nome}"/></p>
                    </td>

                    <td>
                        <p class="h4"><c:out value="${produto.precoVenda}"/></p>
                    </td>

                    <td>
                        <p class="h4"><c:out value="${produto.quantidade}"/></p>
                    </td>

                    <td>
                        <p class="h4"><c:out value="${produto.idContato}"/></p>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
