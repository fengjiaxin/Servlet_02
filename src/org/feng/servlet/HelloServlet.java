package org.feng.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	private String greeting;
	
	@Override
	public void init() throws ServletException {
		greeting = getServletConfig().getInitParameter("greeting");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String welcomeInfo = greeting+",,,"+username;
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.println("<html><head><title>");
		out.println("Welcome Page");
		out.println("</title><head>");
		out.println("<body>");
		out.println(welcomeInfo);
		for(int i=0;i<10;i++) {
			out.println("<h1>"+i+"</h1>");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
