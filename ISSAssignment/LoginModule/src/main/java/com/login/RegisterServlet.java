package com.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String uname=request.getParameter("username");
		String pwd=request.getParameter("password");
		String mobile_no=request.getParameter("mobile_no");
		String email=request.getParameter("email");
		
		String url = "jdbc:sqlserver://localhost:1433;databaseName=project;trustServerCertificate=true";
        String username = "Karina";
        String password = "HAPPY";

        try {
            //connecting the database

            //1.Loading the jdbc driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            //2.establishing the connection
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database");
            
            String insert_query="INSERT INTO company.login VALUES (?,?,?,?)";
            
            PreparedStatement preparedStatement = connection.prepareStatement(insert_query);
            preparedStatement.setString(1,uname );
            preparedStatement.setString(2,pwd );
            preparedStatement.setString(3,mobile_no );
            preparedStatement.setString(4,email );
            
            int row = preparedStatement.executeUpdate();

            // rows affected
            System.out.println(row);
            
            response.sendRedirect("login.jsp");

            
        }
        catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
	}

}
