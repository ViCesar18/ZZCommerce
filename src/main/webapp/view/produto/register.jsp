<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

    <meta charset="utf-8">

    <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous">
    </script>
    <script type="text/javascript"
            src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js">
    </script>

    <script type="text/javascript">
        $(document).ready(function() {
            $("#loginForm").validate({
                rules: {
                    username: {
                        required: true,
                        username: true
                    },

                    password: "required",
                },

                messages: {
                    username: {
                        required: "Please enter email",
                        username: "Please enter a valid email address"
                    },

                    password: "Please enter password"
                }
            });

        });
    </script>

    <script>
        function myFunction() {
            alert("I am an alert box!");
        }
    </script>

    <title>Adicionar Produto</title>
</head>
<body>
<div class="container">
    <div style="display: flex; flex-direction: row">
        <h1>Adicione um Produto!</h1>
    </div>
    <form
            class="form"
            action="${pageContext.servletContext.contextPath}/registerProduto"
            method="post"
    >
        <div class="form-group">
            <label for="inputNome">Nome</label>
            <input type="text" required class="form-control" id="inputNome" name="nome">
        </div>

        <div class="form-group">
            <label for="inputPreco">Preço</label>
            <input type="number" step="0.01" required class="form-control" id="inputPreco" name="preco">
        </div>

        <div class="form-group">
            <label for="inputQuantidade">Quantidade</label>
            <input type="number" required class="form-control" id="inputQuantidade" name="quantidade">
        </div>


        <button type="submit" class="btn btn-primary">Adicionar Produto</button>
        <a type="button" class="btn btn-danger" href="${pageContext.servletContext.contextPath}/view/main_page.jsp">Voltar</a>
    </form>
</div>
<script src="../../assets/js/usuario.js"/>
</body>
</html>