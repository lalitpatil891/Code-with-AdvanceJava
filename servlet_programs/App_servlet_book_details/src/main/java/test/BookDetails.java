package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/set")
public class BookDetails implements Servlet {

	@Override
	public void init(ServletConfig scf) throws ServletException {
		//NO code
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		int bCode = Integer.parseInt(req.getParameter("bcode"));
		String bName = req.getParameter("bname");
		String bAuthor = req.getParameter("bauthor");
		double bPrice = Double.parseDouble(req.getParameter("bprice"));
		int bQty = Integer.parseInt(req.getParameter("bqty"));
		
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		pw.println("****Book Details****<br>");
		pw.println("Book Code: "+bCode+ "<br>");
		pw.println("Book Name: "+bName+ "<br>");
		pw.println("Book Author: "+bAuthor+ "<br>");
		pw.println("Book Price: "+bPrice+ "<br>");
		pw.println("Book QTY: "+bQty+ "<br>");
	}
	
	@Override
	public void destroy() 
	{
		//No code
	}
	
	@Override
	public String getServletInfo()
	{
		return "Servlet displaying User details....";
	}
	
	@Override
	public ServletConfig getServletConfig() 
	{
		return this.getServletConfig();
	}
}
