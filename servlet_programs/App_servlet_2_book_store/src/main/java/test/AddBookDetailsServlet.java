package test;

import java.io.IOException;
import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/add")
public class AddBookDetailsServlet extends GenericServlet {
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
		BookBean bb = new BookBean(); //Bean Object
		bb.setCode(req.getParameter("bcode"));
		bb.setName(req.getParameter("bname"));
		bb.setAuthor(req.getParameter("bauthor"));
		bb.setPrice(Float.parseFloat(req.getParameter("bprice")));
		bb.setQty(Integer.parseInt(req.getParameter("bqty")));
		
		int k = new AddBookDetailsDAO().insert(bb);
		
		if(k>0)
		{
			req.setAttribute("msg", "BookDetails Added Successfully..<br>");
			 
			RequestDispatcher rd = req.getRequestDispatcher("AddBookDetails.jsp");
			
			rd.forward(req,res);
		}else
		{
			req.setAttribute("msg", "invalid!");
		}
	}
}
