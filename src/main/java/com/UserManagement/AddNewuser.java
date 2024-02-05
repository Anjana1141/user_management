package com.UserManagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddNewuser")
public class AddNewuser extends HttpServlet {

   
 


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagement", "root","root" );
            		
                
                String sql = "INSERT INTO user(id, name, phoneNumber, company, emailId, address) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                	int id = Integer.parseInt(req.getParameter("Id"));
                	String phoneNumber = req.getParameter("phoneNumber");
                	String name = req.getParameter("name");
                	String company= req.getParameter("company");
                	String emailId = req.getParameter("emailId");
                	String address= req.getParameter("address");

                	
                	    
                	        preparedStatement.setInt(1, id);
                	        preparedStatement.setString(2, name);
                	        preparedStatement.setString(3, phoneNumber);
                	        preparedStatement.setString(4, company);
                	        preparedStatement.setString(5, emailId);
                	        preparedStatement.setString(6, address);
                	     
                	        
                    
                  
                    preparedStatement.executeUpdate();
                
            
        }
         catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); 
        }
    }
}
