package test;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotaion;

@WebServlet("/add")
public class AddBookDetailsServlet extends GenericServlet {
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
		BookBean bb = new BookBeam(); //Bean Object
		bb.setCode(req.getParameter("bcode"));
		bb.setName(req.getParameter("bname"));
		bb.setAuthor(req.getParameter("bauthor"));
		bb.setPrice(Float.parseFloat(req.getParameter("bqty")));
		bb.setQty(Integer.parseInt(req.getParameter("bqty")));
		
		int k = new AddBookDetailsDAO().insert(bb);
		
		if(k>0)
		{
			req.setAttribute("msg", "BookDetails Added Successfully..<br>");
			 
			RequestDispatcher rd = req.getRequestDispatcher("AddBookDetails.jsp");
			
			rd.forward(req,res);
		}	
	}
}
