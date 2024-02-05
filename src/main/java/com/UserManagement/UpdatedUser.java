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
@WebServlet("/updateUser")
public class UpdatedUser  extends HttpServlet{
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phoneNumber = req.getParameter("phoneNumber");
		String company = req.getParameter("company");
		String address = req.getParameter("address");

		try {
			String query = "UPDATE user SET name=? , emailId=? , phoneNumber=? ,company=? ,address=? WHERE id=?";
			PreparedStatement preparedStatement = getConnection().prepareStatement(query);


			preparedStatement.setString(1,name);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, phoneNumber);
			preparedStatement.setInt(6, id);
			preparedStatement.setString(4, company);
			preparedStatement.setString(5, address);

			preparedStatement.executeUpdate();

			preparedStatement.close();
			getConnection().close();

//			resp.sendRedirect("Success.jsp?msg=Updated"); 
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		
		}
	}
}
