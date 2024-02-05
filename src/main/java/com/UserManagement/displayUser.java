package com.UserManagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DisplayDetails")
public class displayUser extends HttpServlet{
	
	public static Connection  getConnection() {
		Connection  con = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");


			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement", "root", "root");


		} catch (Exception e) {
			e.printStackTrace();

		}
		return con;

	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    try {
	        String query = "SELECT * FROM user";
	        PreparedStatement preparedStatement = getConnection().prepareStatement(query);

	        ResultSet resultSet = preparedStatement.executeQuery();

	        List users = new ArrayList();
	        while (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            String name = resultSet.getString("name");
	            String emailId = resultSet.getString("emailId");
	             int phoneNumber = resultSet.getInt("phoneNumber");
	             String company = resultSet.getString("company");
	             String address= resultSet.getString("address");

	            

	            users.add(id);
	            users.add(name);
	            users.add(emailId);
	            users.add(phoneNumber);
	            users.add(company);
	            users.add(address);
	        }

	        req.setAttribute("DisplayUser", users);
	        RequestDispatcher requestDispatcher = req.getRequestDispatcher("DisplayUser.jsp");
	        requestDispatcher.forward(req, resp);

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}
