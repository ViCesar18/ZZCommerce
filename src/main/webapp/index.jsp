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
        <title>Login</title>
    </head>
    <body>
        <div class="container">
            <div style="display: flex; flex-direction: row">
                <div>
                    <h1>Seja Bem Vindo ao ZZCommerce!</h1>
                    <h2>Entre ou Cadastre-se.</h2>
                </div>
            </div>
            <form
                    action="${pageContext.servletContext.contextPath}/login"
                    method="post"
            >
                <div class="form-group">
                    <label for="inputUser">Usuário</label>
                    <input type="text" class="form-control" id="inputUser" name="username">
                </div>
                <div class="form-group">
                    <label for="inputSenha">Senha</label>
                    <input type="password" class="form-control" id="inputSenha" name="password">
                </div>

                <button type="submit" class="btn btn-primary">Entrar</button>
                <a class="btn btn-success" href="view/contato/register.jsp">Criar Conta</a>
            </form>
        </div>
    </body>

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
</html>