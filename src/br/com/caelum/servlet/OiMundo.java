package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@WebServlet(
			name = "servletOiMundo", 
			urlPatterns = {"/oi", "/ola"},
			initParams = {
					@WebInitParam(name = "environment-type", value = "dev"),
					@WebInitParam(name = "bd-type", value = "dev")}
			)
public class OiMundo extends HttpServlet {
	private String environmentType;
	private String bdType;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.environmentType = config.getInitParameter("environment-type");
		this.bdType = config.getInitParameter("bd-type");
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		ServletConfig config = getServletConfig();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Primeira Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Oi mundo Servlet!</h1>");
		
		out.println("[environment-type] " +
				"[" +
				this.environmentType  + "]<BR>"
				);

		out.println("[bd-type] " +
				"[" +
				this.bdType  + "]<BR>"
				);

		out.println("</body>");
		out.println("</html>");
		response.setContentType("text/html;charset=UTF-8");
	}

}
