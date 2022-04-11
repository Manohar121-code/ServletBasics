package com.servlet.basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/InvalidateSession")
public class InvalidateSession extends HttpServlet {

	public void init() {
		System.out.println("InvalidateSession Servlet initialized successfully");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print("<h1>Current Session Invalidated</h1>");
	}
	
	public void destroy() {
		
	}
	
}
