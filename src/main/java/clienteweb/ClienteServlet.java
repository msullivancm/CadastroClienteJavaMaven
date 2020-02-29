package clienteweb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/cliente", "/clienteControler", "/clienteServlet"})
public class ClienteServlet extends HttpServlet {
	
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
		super.service(req, resp); //Este método chama os demais. Se não mantiver o método original não vai continuar com o doget, dopost etc.
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Chamou pelo metodo GET");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("Chamou pelo metodo POST");
		String email = req.getParameter("email");
		
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().print("Chamou pelo método POST enviando e-mail: "+ email +"!");
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
