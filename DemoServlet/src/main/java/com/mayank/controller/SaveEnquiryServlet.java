package com.mayank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveEnquiryServlet
 */
public class SaveEnquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  PrintWriter out = response.getWriter();
	        System.out.println("--------service(..)-----------");
	        //Read form data from request object
	        String n=request.getParameter("name"); //form-field-name
	        String ph=request.getParameter("phone");
	        String g=request.getParameter("gender");
	        String c=request.getParameter("city");
	        String a=request.getParameter("address");
	        String[] courseArray=request.getParameterValues("courses");
	        //TODO: write jdbc code/hib/JPA/Spring JDBC or Call service/biz method,
	        System.out.println("Name: "+n);
	        System.out.println("Phone: "+ph);
	        System.out.println("Gender: "+g);
	        System.out.println("City Code/Value: "+c);
	        System.out.println("Address: "+a);
	        System.out.println("Selected Courses: ");
	        for (String aCourse : courseArray) {
	            System.out.println(aCourse);
	        }
	        out.println("TODO: Data stored successfully.");
	}

}
