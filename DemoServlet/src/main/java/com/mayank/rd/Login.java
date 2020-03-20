package com.mayank.rd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String n = request.getParameter("name");
		String p = request.getParameter("password");
		if (p.equalsIgnoreCase("admin")) {
			out.println("<h1 style='color:yellow'> Name:" + n + " Password:" + p + "</h1>");
			/*
			 * RequestDispatcher rd = request.getRequestDispatcher("welcome");
			 * rd.forward(request, response);
			 */
			response.sendRedirect("https://www.javatpoint.com/sendRedirect()-method");

			// admin
		} else {
			out.println("<h1 style='color:red'>Password not match</h1>");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);

		}
	}

}
