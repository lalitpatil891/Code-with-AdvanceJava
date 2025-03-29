package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/sub")
public class EmployeeDetails implements Servlet {
	
	@Override
	public void init(ServletConfig scf) throws ServletException
	{
		//NoCode
	}

	@Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // Set response content type
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();

        // Retrieving form data
        String eName = req.getParameter("ename");
        String eAge = req.getParameter("eage");
        String eSal = req.getParameter("esal");
        String eMail = req.getParameter("email");
        String eGender = req.getParameter("egender");
        String[] eHobbies = req.getParameterValues("hobbies");
        String eState = req.getParameter("states");

        // Printing form data
        pw.println("<html><body>");
        pw.println("<h2>****** Employee Details ******</h2>");
        pw.println("<p><b>Name:</b> " + eName + "</p>");
        pw.println("<p><b>Age:</b> " + eAge + "</p>");
        pw.println("<p><b>Salary:</b> " + eSal + "</p>");
        pw.println("<p><b>Email:</b> " + eMail + "</p>");
        pw.println("<p><b>Gender:</b> " + (eGender != null ? eGender : "Not specified") + "</p>");
        
        pw.println("<p><b>Hobbies:</b> ");
        if (eHobbies != null) {
            for (String hobby : eHobbies) {
                pw.print(hobby + " ");
            }
        } else {
            pw.print("No hobbies selected");
        }
        pw.println("</p>");

        pw.println("<p><b>State:</b> " + eState + "</p>");
        pw.println("</body></html>");

        pw.close();
    }
	
	
	@Override
	public void destroy()
	{
		//NoCode
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

