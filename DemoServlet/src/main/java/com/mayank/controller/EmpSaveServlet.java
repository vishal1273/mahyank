package com.mayank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpSaveServlet
 */
public class EmpSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String n = req.getParameter("name");
		String d = req.getParameter("designation");

		System.out.println("Form data--->");
		System.out.println(n);
		System.out.println(d);
		try {
			this.saveData(n, d);
			out.println("Data stored successfully.<br/>");
			out.println("<a href=\"emp.html\">EMP FORM</a><br/>");
			out.println("<a href=\"ers\">EMP LIST</a><br/>");
		} catch (Exception ex) {
			ex.printStackTrace();
			out.println("ERROR: failed to save data : " + ex);
		}

	}

	void saveData(String name, String designation) throws Exception {
		// write jdbc/hib/JPA/Spring JDBC Template: code here to save data into database
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sabu_db?user=root&password=root");
		String sql = "INSERT INTO employee(name,designation) VALUE(?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, name);
		pst.setString(2, designation);
		pst.executeUpdate();
	}

}
