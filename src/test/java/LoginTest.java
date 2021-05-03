import com.uel.ZZCommerce.controller.LoginServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LoginTest extends Mockito {

  @Test
  void testarSucessoNoLogin() throws ServletException, IOException {
    HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

    when(request.getParameter("username")).thenReturn("admin");
    when(request.getParameter("password")).thenReturn("123");
    when(request.getServletPath()).thenReturn("/login");
    when(request.getParameter("Test")).thenReturn("Sim");

    new LoginServlet().doPost(request, response);

    verify(request).setAttribute("messagemSucesso", "Usuário logado com sucesso!");
  }

  @Test
  void testarFalhaNoLogin() {
    HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

    when(request.getParameter("username")).thenReturn("administrador");
    when(request.getParameter("password")).thenReturn("123456");
    when(request.getServletPath()).thenReturn("/login");
    when(request.getParameter("Test")).thenReturn("Sim");

    LoginServlet loginServlet = new LoginServlet();

    Assertions.assertThrows(SecurityException.class, () -> loginServlet.doPost(request, response));
  }
}
