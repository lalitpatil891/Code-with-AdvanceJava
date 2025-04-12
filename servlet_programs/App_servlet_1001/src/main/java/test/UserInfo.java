/** 1001 means -> Task Day1-Task1*/

package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/user")
public class UserInfo implements Servlet {

	@Override
	public void init(ServletConfig scf) throws ServletException
	{
			//Nocode
	}
		
	@Override
	public void service(ServletRequest req, ServletResponse res)throws ServletException, IOException 
	{
			int uId = Integer.parseInt(req.getParameter("uid"));
			String FName = req.getParameter("fname");
			String LName = req.getParameter("lname");
			String MailId = req.getParameter("mid");
			long phNo = Long.parseLong(req.getParameter("phno"));
			
			PrintWriter pw = res.getWriter();
			
			res.setContentType("text/html");
			
			
			pw.println("****USER INFO****");
			pw.println("uId: "+uId+"<br>");
			pw.println("FName: "+FName+"<br>");
			pw.println("LName: "+LName+"<br>");
			pw.println("MailId: "+MailId+"<br>");
			pw.println("phNo: "+phNo+"<br>");
		}
		
		@Override
		public void destroy()
		{
			//Nocode
		}
		
		@Override
		public String getServletInfo()
		{
			return "Servlet displaying user details...";
		}
		
		@Override
		public ServletConfig getServletConfig() 
		{
			return this.getServletConfig();
		}
		
}
