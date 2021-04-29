<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="./assets/css/logon.css">
        <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
        <script type="text/javascript"
            src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js">
        </script>
        <title>Login</title>
    </head>
    <body>
        <div class="logon-container">
            <div class="content">
                <section>
                    <img src="assets/img/zz-logo.png" />

                    <form
                            action="${pageContext.servletContext.contextPath}/login"
                            method="post"
                    >
                        <h1>Faça seu Logon</h1>

                        <div class="form-group">
                            <input type="text" placeholder="Usuário" required class="form-control" id="inputUser" name="username">
                        </div>
                        <div class="form-group">
                            <input type="password" placeholder="Senha" required class="form-control" id="inputSenha" name="password">
                        </div>

                        <div class="buttons">
                            <button type="submit" class="btn btn-primary">Entrar</button>
                            <div class="link">
                                <i class="fas fa-sign-in-alt" style="color: #2C88D9"></i>
                                <a href="view/contato/register.jsp">Criar Conta</a>
                            </div>
                        </div>
                    </form>
                </section>

                <img src="assets/img/commerce.png" />
            </div>
        </div>
    </body>
</html>