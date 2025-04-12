/** Task Day2-Task2 -> 2002*/
package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/set")
public class Hobbies implements Servlet {

	
	@Override
	public void init(ServletConfig arg0) throws ServletException {

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		String Name = req.getParameter("name");
		String []Hobbies = req.getParameterValues("hob");
		
		
		pw.println("*** Details ****");
		pw.println("name : "+Name);
		pw.println("Hobbies: "+Arrays.toString(Hobbies));
	}
	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServletConfig getServletConfig() {
		return this.getServletConfig();
	}
}
