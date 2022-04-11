package com.servlet.basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PutDataIntoSession")
public class PutSession extends HttpServlet {

	public void init() {
		System.out.println("PutDataIntoSession Servlet initialized successfully");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		String country = request.getParameter("country");
		
		HttpSession session = request.getSession(true);
		session.setAttribute("name", name);
		session.setAttribute("country", country);
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print("<h1>Details put into session successfully</h1>");
	}
	
	public void destroy() {
		
	}
	
}
