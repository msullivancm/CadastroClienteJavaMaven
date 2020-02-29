package clienteweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tibrasil.model.Cliente;

@WebServlet(urlPatterns = { "/cliente", "/clienteControler", "/clienteServlet" })
public class ClienteServlet extends HttpServlet {

	List<Cliente> lista = new ArrayList<>();
	private RequestDispatcher dispatcher;

	public ClienteServlet() {
		System.out.println("construindo Servlet...");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Inicializando Servlet");
		super.init();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Chamando o service...");
		super.service(req, resp); // Este método chama os demais. Se não mantiver o método original não vai
									// continuar com o doget, dopost etc.
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Cria o dispatcher para redirecionar a requisição para a pagina jsp
		dispatcher = req.getRequestDispatcher("cliente.jsp");
		req.setAttribute("lista", lista);
		dispatcher.forward(req, resp);

		System.out.println("Chamou pelo metodo GET");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// System.out.println("Chamou pelo metodo POST");

		// Recebendo o email do html como parametro
		String email = req.getParameter("email");

		// Colocando email em um objeto cliente
		Cliente cli = new Cliente();
		cli.setEmail(email);

		// adicionando cliente na lista de clientes
		lista.add(cli);

		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print("Chamou pelo método POST enviando e-mail: " + email + "!");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("Chamou pelo método DELETE");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("Chamou pelo método PUT");
	}

	@Override
	public void destroy() {
		System.out.println("Servlet a ser destruído");
		super.destroy();
	}
}
