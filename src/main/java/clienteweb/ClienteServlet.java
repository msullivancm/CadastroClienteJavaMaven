package clienteweb;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tibrasil.model.Cliente;
import net.tibrasil.service.ClienteService;

@WebServlet(urlPatterns = { "/cliente", "/clienteControler", "/clienteServlet" })
public class ClienteServlet extends HttpServlet {
	ClienteService clienteService;

	private RequestDispatcher dispatcher;

	public ClienteServlet() {
		System.out.println("construindo Servlet...");
	}

	@Override
	public void init() throws ServletException {
		clienteService = new ClienteService();
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
		String i = req.getParameter("i");
		if (i!=null && i!="") {
			clienteService.excluir(Integer.parseInt(i));
		}
		
		// Cria o dispatcher para redirecionar a requisição para a pagina jsp
		dispatcher = req.getRequestDispatcher("cliente.jsp");
		req.setAttribute("lista", clienteService.getTodosClientes());
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
		clienteService.cadastrar(cli);

		System.out.println("Chamou pelo método POST enviando e-mail: " + email + "!");

		// Chama o método get novamente para exibir a página de formulário
		// Cria o dispatcher para redirecionar a requisição para a pagina jsp com um
		// parâmetro a mais
		dispatcher = req.getRequestDispatcher("cliente.jsp");
		req.setAttribute("lista", clienteService.getTodosClientes());
		req.setAttribute("msg", "Atualizado com sucesso!");
		dispatcher.forward(req, resp);

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
