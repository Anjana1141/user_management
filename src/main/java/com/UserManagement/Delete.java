package com.UserManagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DeleteUser")
public class Delete extends HttpServlet{
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
		int id = Integer.parseInt(req.getParameter("id"));
		
		try {
			String query = "DELETE FROM user WHERE id=?";
			PreparedStatement preparedStatement = getConnection().prepareStatement(query);
			
			preparedStatement.setInt(1, id);
			
			preparedStatement.executeUpdate();
			
			preparedStatement.close();
			getConnection().close();

			resp.sendRedirect("check.jsp?msg=Deleted"); 
		}
		catch (Exception e) {
		e.printStackTrace();
		}
	}
}
