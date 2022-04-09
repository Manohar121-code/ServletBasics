package com.servlet.basics;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetEmployee")
public class GetEmployee extends HttpServlet {

	public void init() {
		System.out.println("List Employee Servlet initialized successfully");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/servlet_data";
		String userName = "root";
		String password = "manah";
		
		String idStr = request.getParameter("id");
		int idInput = Integer.parseInt(idStr);
		
		String sql = "select * from employee where id = ?";
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		try {
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			
			Class.forName(driver);
			connection = DriverManager.getConnection(url, userName, password);
			prepareStatement = connection.prepareStatement(sql);
			
			prepareStatement.setInt(1, idInput);
			
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int salary = rs.getInt("Salary");
				Employee e = new Employee(id, name, salary);
				writer.print("<h1>"+ e +"</h1>");
			}
			
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