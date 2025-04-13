package test;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewBookDetailsServlet extends GenericServlet {

		@Override
		public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
		{
			String bcode = req.getParameter("bcode");
			BookBean bb = new ViewBookDetailsDAO().retrieve(bcode);
			
			if(bb == null) {
				req.setAttribute("msg","Invalid BookCode...<br>");
				req.getRequestDispatcher("Msg.jsp").forward(req, res);
			}
			else
			{
				req.setAttribute("bbean", bb);
				req.getRequestDispatcher("ViewBookDetails.jsp").forward(req, res);		
			}
		}
}
