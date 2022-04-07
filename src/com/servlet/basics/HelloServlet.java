package com.servlet.basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {

	//Life cycle of servlet
	//initialization
	//service
	//destroy
	
	public void init() {
		System.out.println("Hello Servlet initialized successfully");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print("<h1>Hello Servlet</h1>");
	}
	
	public void destroy() {
		
	}
	
}
