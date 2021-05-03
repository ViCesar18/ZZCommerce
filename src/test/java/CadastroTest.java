import com.uel.ZZCommerce.controller.RegisterServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CadastroTest extends Mockito {

  @Test
  void testarCadastroValido() throws ServletException, IOException {
    HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

    when(request.getParameter("username")).thenReturn("admin");
    when(request.getParameter("senha")).thenReturn("123");
    when(request.getParameter("nome")).thenReturn("Administrador");
    when(request.getParameter("apelido")).thenReturn("adm");
    when(request.getParameter("empresa")).thenReturn("UEL");
    when(request.getParameter("endereco")).thenReturn("Rua Exemplo");
    when(request.getParameter("bairro")).thenReturn("Bairro Exemplo");
    when(request.getParameter("cidade")).thenReturn("Londrina");
    when(request.getParameter("telefone1")).thenReturn("912345678");
    when(request.getParameter("telefone2")).thenReturn("987654321");
    when(request.getParameter("observacao")).thenReturn("Sem observacao.");
    when(request.getParameter("Test")).thenReturn("Sim");

    new RegisterServlet().doPost(request, response);

    verify(request).setAttribute("mensagemSucesso", "Cadastro executado com sucesso!");
  }

  @Test
  void testarCadastroInvalido() {
    HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

    when(request.getParameter("username")).thenReturn("admin");
    when(request.getParameter("senha")).thenReturn("123");
    when(request.getParameter("nome")).thenReturn("Administrador");
    when(request.getParameter("apelido")).thenReturn("adm");
    when(request.getParameter("empresa")).thenReturn("UEL");
    when(request.getParameter("endereco")).thenReturn("Rua Exemplo");
    when(request.getParameter("bairro")).thenReturn("Bairro Exemplo");
    when(request.getParameter("cidade")).thenReturn("Londrina");
    when(request.getParameter("telefone1")).thenReturn("912345678");
    when(request.getParameter("telefone2")).thenReturn("987654321");
    when(request.getParameter("observacao")).thenReturn("Sem observacao.");
    when(request.getParameter("Test")).thenReturn("Sim");

    RegisterServlet registerServlet = new RegisterServlet();

    Assertions.assertThrows(
        RuntimeException.class, () -> registerServlet.doPost(request, response));
  }
}
