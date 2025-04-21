package com.example_of_sendredirect_method;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SqServlet extends HttpServlet {
	
public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		int k = Integer.parseInt(req.getParameter("k"));
		
		k = k*k ;
	
		PrintWriter out = res.getWriter();
		out.println("Result is" +k);
		
	
		System.out.println("sq called");
	}
}
