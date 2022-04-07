package com.servlet.basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloPerson")
public class HelloPerson extends HttpServlet {

	//Life cycle of servlet
	//initialization
	//service
	//destroy
	
	public void init() {
		System.out.println("Hello Person Servlet initialized successfully");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print("<h1>Hello "+ name+"</h1>");
	}
	
	public void destroy() {
		
	}
	
}
