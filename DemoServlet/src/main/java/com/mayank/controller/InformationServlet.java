package com.mayank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InformationServlet
 */
public class InformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        out.println("<br/>-----------CLIENT INFO----------");
	        System.out.println("-----------CLIENT INFO----------");

	        out.println("<br/>Client IP : "+ request.getRemoteAddr());
	        System.out.println("Client IP : "+ request.getRemoteAddr());

	        out.println("<br/>Client Lang : "+ request.getHeader("Accept-Language"));
	        System.out.println("Client Lang : "+ request.getHeader("Accept-Language"));

	        out.println("<br/>Client Browser : "+ request.getHeader("User-Agent"));
	        System.out.println("Client Browser : "+ request.getHeader("User-Agent"));

	        out.println("<br/>Client Request Method : "+ request.getMethod());
	        System.out.println("Client Request Method : "+ request.getMethod());

	        out.println("<br/>Client Request URI : "+ request.getRequestURI());
	        System.out.println("Client Request URI : "+ request.getRequestURI());

	        out.println("------SERVER INFO-----------");
	        System.out.println("------SERVER INFO-----------");

	        ServletContext application=getServletContext();
	        out.println("<br/>SERVER : "+application.getServerInfo());
	        System.out.println("SERVER : "+application.getServerInfo());

	        out.println("<br/>Context Path : "+application.getContextPath());
	        System.out.println("Context Path : "+application.getContextPath());

	        out.println("<br/>Java Ver : "+ System.getProperty("java.version"));
	        System.out.println("Java : "+ System.getProperty("java.version"));

	        out.println("<br/>Java Vendor : "+ System.getProperty("java.vendor"));
	        System.out.println("Java Vendor: "+ System.getProperty("java.vendor"));

	        out.println("<br/>System User : "+ System.getProperty("user.name"));
	        System.out.println("System User : "+ System.getProperty("user.name"));

	        out.println("<br/>User Dir/Current Dir : "+ System.getProperty("user.dir"));
	        System.out.println("User Dir/Current Dir : "+ System.getProperty("user.dir"));

	        out.println("<br/>Server OS : "+ System.getProperty("os.name"));
	        System.out.println("Server OS : "+ System.getProperty("os.name"));

	        Runtime rt=Runtime.getRuntime();
	        long mem=rt.maxMemory()/1024/1024;

	        out.println("<br/>Heap Size Max(MB) : "+ mem);
	        System.out.println("Heap Size Max(KB) : "+ mem);
	}

}
