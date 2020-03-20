package com.mayank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpReportServlet
 */
public class EmpReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Emp Report</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Emp Report</h1>");
		out.println("<a href=\"emp.html\">EMP FORM</a>");
		out.println("<table border=\"1\">");
		out.println("<tr>");
		out.println("<td>ID</td>");
		out.println("<td>NAME</td>");
		out.println("<td>SALARY</td>");
		out.println("</tr>");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sabu_db?user=root&password=root");
			String sql = "select * from emp";
			PreparedStatement pst = con.prepareStatement(sql);

			ResultSet rs = pst.executeQuery("SELECT * FROM employee");
			while (rs.next()) {
				int id = rs.getInt("id");
				String n = rs.getString("name");
				String d  = rs.getString("designation");
				// out.println(id + " " + n + " " + s);
				out.println("<tr>");
				out.println("<td>" + id + "</td>");
				out.println("<td>" + n + "</td>");
				out.println("<td>" + d + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			// use finally block
			rs.close();
			pst.close();
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		out.println("</body>");
		out.println("</html>");
	}

}
