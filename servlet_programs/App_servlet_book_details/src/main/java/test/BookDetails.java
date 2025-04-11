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
		
		/*pw.println("****Book Details****<br>");
		pw.println("Book Code: "+bCode+ "<br>");
		pw.println("Book Name: "+bName+ "<br>");
		pw.println("Book Author: "+bAuthor+ "<br>");
		pw.println("Book Price: "+bPrice+ "<br>");
		pw.println("Book QTY: "+bQty+ "<br>");*/
		
		pw.println("<!DOCTYPE html>");
	    pw.println("<html>");
	    pw.println("<head>");
	    pw.println("<title>Book Details</title>");
	    pw.println("<style>");
	    pw.println("body { font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px; }");
	    pw.println(".container { background-color: white; padding: 20px; border-radius: 8px; width: 400px; margin:100px auto; box-shadow: 0 0 10px rgba(0,0,0,0.1); }");
	    pw.println("h2 { color: #333; text-align: center; }");
	    pw.println("p { font-size: 16px; margin: 10px 0; }");
	    pw.println("</style>");
	    pw.println("</head>");
	    pw.println("<body>");
	    pw.println("<div class='container'>");
	    pw.println("<h2>📚 Book Details</h2>");
	    pw.println("<p><strong>Book Code:</strong> " + bCode + "</p>");
	    pw.println("<p><strong>Book Name:</strong> " + bName + "</p>");
	    pw.println("<p><strong>Book Author:</strong> " + bAuthor + "</p>");
	    pw.println("<p><strong>Book Price:</strong> ₹" + bPrice + "</p>");
	    pw.println("<p><strong>Book Quantity:</strong> " + bQty + "</p>");
	    pw.println("</div>");
	    pw.println("</body>");
	    pw.println("</html>");
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
