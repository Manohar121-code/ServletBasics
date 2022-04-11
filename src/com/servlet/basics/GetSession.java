package com.servlet.basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/GetDataFromSession")
public class GetSession extends HttpServlet {

	public void init() {
		System.out.println("GetDataFromSession Servlet initialized successfully");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		String country = (String) session.getAttribute("country");
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print("<h1>Name - "+ name +" & Country - "+ country +" </h1>");
	}
	
	public void destroy() {
		
	}
	
}
