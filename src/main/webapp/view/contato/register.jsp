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

        <title>Criar Conta</title>
    </head>
    <body>
        <div class="container">
            <div style="display: flex; flex-direction: row">
                <h1>Crie sua conta!</h1>
            </div>
            <form
                    class="form"
                    action="${pageContext.servletContext.contextPath}/register"
                    method="post"
            >
                <div class="form-group">
                    <label for="inputUsername">Usuário</label>
                    <input type="text" required class="form-control" id="inputUsername" name="username">
                </div>

                <div class="form-group">
                    <label for="inputSenha">Senha</label>
                    <input type="password" required class="form-control password-input" id="inputSenha" name="senha">
                </div>

                <div class="form-group">
                    <label for="inputSenhaConfirmacao">Confirme sua Senha</label>
                    <input type="password" required class="form-control .password-confirm" id="inputSenhaConfirmacao" name="senhaConfirmacao">
                    <p class="help-block" style="color: red"></p>
                </div>

                <div class="form-group">
                    <label for="inputNome">Nome</label>
                    <input type="text" required class="form-control" id="inputNome" name="nome">
                </div>

                <div class="form-group">
                    <label for="inputApelido">Apelido</label>
                    <input type="text" required class="form-control" id="inputApelido" name="apelido">
                </div>

                <div class="form-group">
                    <label for="inputEmpresa">Empresa</label>
                    <input type="text" required class="form-control" id="inputEmpresa" name="empresa">
                </div>

                <div class="form-group">
                    <label for="inputEndereco">Endereço</label>
                    <input type="text" required class="form-control" id="inputEndereco" name="endereco">
                </div>

                <div class="form-group">
                    <label for="inputBairro">Bairro</label>
                    <input type="text" required class="form-control" id="inputBairro" name="bairro">
                </div>

                <div class="form-group">
                    <label for="inputCidade">Cidade</label>
                    <input type="text" required class="form-control" id="inputCidade" name="cidade">
                </div>

                <div class="form-group">
                    <label for="inputTelefone1">Telefone 1</label>
                    <input type="tel" required class="form-control" id="inputTelefone1" name="telefone1">
                </div>

                <div class="form-group">
                    <label for="inputTelefone2">Telefone 2</label>
                    <input type="tel" required class="form-control" id="inputTelefone2" name="telefone2">
                </div>

                <div class="form-group">
                    <label for="inputObservacao">Observação</label>
                    <input type="tel" required class="form-control" id="inputObservacao" name="observacao">
                </div>

                <button type="submit" class="btn btn-primary">Criar Conta</button>
                <a type="button" class="btn btn-danger" href="${pageContext.servletContext.contextPath}/">Voltar</a>
            </form>
        </div>
    <script src="../../assets/js/usuario.js"/>
    </body>
</html>