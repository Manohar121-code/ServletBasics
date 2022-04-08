package com.servlet.basics;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//CRUD
//CREATE - POST
//READ - GET
//UPDATE - PUT
//DELETE - DELETE

@WebServlet("/SaveEmployee")
public class SaveEmployee extends HttpServlet {

	public void init() {
		System.out.println("Save Employee Servlet initialized successfully");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/servlet_data";
		String userName = "root";
		String password = "manah";
		
		String name = request.getParameter("name");
		Integer salary = Integer.parseInt(request.getParameter("salary"));
		
		String sql = "insert into employee(name, salary) values(?, ?)";
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, userName, password);
			prepareStatement = connection.prepareStatement(sql);
			
			prepareStatement.setString(1, name);
			prepareStatement.setInt(2, salary);
			
			prepareStatement.executeUpdate();
			
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			writer.print("<h1>Employee Saved successfully</h1>");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null && prepareStatement != null) {
				try {
					connection.close();
					prepareStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void destroy() {
		
	}
	
}













