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

@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
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
		int Id=Integer.parseInt(req.getParameter("id"));

		String query = "SELECT * FROM user WHERE id=?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = getConnection().prepareStatement(query);
			preparedStatement.setInt(1, Id);
			ResultSet resultSet = preparedStatement.executeQuery();

			List users = new ArrayList();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String phoneNumber = resultSet.getString("phoneNumber");
				String emailId = resultSet.getString("emailId");
				String company = resultSet.getString("company");
				String address = resultSet.getString("address");
				


				users.add(id);
				users.add(name);
				users.add(emailId);
				users.add(address);
				users.add(company);
				users.add(phoneNumber);
			}
			req.setAttribute("existingUsers", users);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("UpdateUser.jsp");
			requestDispatcher.forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	

}
