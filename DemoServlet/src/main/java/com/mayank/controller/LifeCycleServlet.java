package com.mayank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleServlet extends HttpServlet {
	public LifeCycleServlet() {
		System.out.println("--Object Created : Def Const LifeCycleServlet()----------");
	}

	@Override
	public void init() {
		System.out.println("--------init()--------");
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		System.out.println("------service()-------");
		out.println("---service() method called---");
	}

	@Override
	public void destroy() {
		System.out.println("---------destroy()------------");
	}

}
