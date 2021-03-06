<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="../../assets/css/register.css">
        <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
        <title>Criar Conta</title>
    </head>
    <body>
        <div class="register-container">
            <div class="content">
                <section>
                    <image src="../../assets/img/zz-logo.png"/>
                    <h1>Crie sua conta!</h1>
                        <p>Faça seu cadastro, entre na plataforma e comercialize seus produtos!</p>
                    <div>
                        <a type="button" href="${pageContext.servletContext.contextPath}/">
                            <i class="fas fa-arrow-left" style="color: #2C88D9"></i>
                            Voltar para Login
                        </a>
                    </div>
                </section>
                <form
                        class="form"
                        action="${pageContext.servletContext.contextPath}/register"
                        method="post"
                >
                    <div class="form-group">
                        <input type="text" placeholder="Usuário" required class="form-control" id="inputUsername" name="username">
                    </div>

                    <div class="form-group">
                        <input type="password" placeholder="Senha" required class="form-control password-input" id="inputSenha" name="senha">
                    </div>

                    <div class="form-group">
                        <input type="password" placeholder="Confirmação de Senha" required class="form-control password-confirm" id="inputSenhaConfirmacao" name="senhaConfirmacao">
                    </div>

                    <p id="mensagem-senha" style="color: red" hidden>As senhas devem ser iguais!</p>

                    <div class="form-group">
                        <input type="text" placeholder="Nome" required class="form-control" id="inputNome" name="nome">
                    </div>

                    <div class="form-group">
                        <input type="text" placeholder="Apelido" required class="form-control" id="inputApelido" name="apelido">
                    </div>

                    <div class="form-group">
                        <input type="text" placeholder="Empresa" required class="form-control" id="inputEmpresa" name="empresa">
                    </div>

                    <div class="form-group">
                        <input type="text" placeholder="Endereço" required class="form-control" id="inputEndereco" name="endereco">
                    </div>

                    <div class="form-group">
                        <input type="text" placeholder="Bairro" required class="form-control" id="inputBairro" name="bairro">
                    </div>

                    <div class="form-group">
                        <input type="text" placeholder="Cidade" required class="form-control" id="inputCidade" name="cidade">
                    </div>

                    <div class="form-group">
                        <input type="tel" placeholder="Telefone 1" required class="form-control" id="inputTelefone1" name="telefone1">
                    </div>

                    <div class="form-group">
                        <input type="tel" placeholder="Telefone 2" required class="form-control" id="inputTelefone2" name="telefone2">
                    </div>

                    <div class="form-group">
                        <input type="tel" placeholder="Observação" required class="form-control" id="inputObservacao" name="observacao">
                    </div>

                    <div class="buttons">
                        <button type="submit" id="botao">Criar Conta</button>
                    </div>
                </form>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script>
            var senha = document.getElementById("inputSenha")
            var confSenha = document.getElementById("inputSenhaConfirmacao")

            function verificarSenha(){
              if(senha.value !== confSenha.value) {
                senha.classList.add('has-error')
                confSenha.classList.add('has-error')
                document.getElementById("botao").setAttribute("disabled", "disabled")
                document.getElementById("mensagem-senha").removeAttribute("hidden")
              } else {
                senha.classList.remove('has-error')
                confSenha.classList.remove('has-error')
                document.getElementById("botao").removeAttribute("disabled")
                document.getElementById("mensagem-senha").setAttribute("hidden", "hidden")
              }
            }

            senha.onkeyup = verificarSenha;
            confSenha.onkeyup = verificarSenha;
        </script>
    </body>
</html>