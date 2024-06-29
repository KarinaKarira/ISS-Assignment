package com.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String uname=request.getParameter("username");
		String pwd=request.getParameter("password");
		boolean isValid=true;
		HttpSession session=request.getSession();
		
		//checking the values that we have got from the front end with that in the backend
		
		String url = "jdbc:sqlserver://localhost:1433;databaseName=project;trustServerCertificate=true";
        String username = "Karina";
        String password = "HAPPY";
        String backend_pwd="";
        

        try {
            //connecting the database

            //1.Loading the jdbc driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            //2.establishing the connection
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database");
            
            String select_query="SELECT password FROM company.login WHERE username=?";
            PreparedStatement statement=connection.prepareStatement(select_query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            statement.setString(1, uname);
            ResultSet resultSet=statement.executeQuery();
            
            
            if(!resultSet.next()) {
            	System.out.println("result set is null");
            	isValid=false;
            	session.setAttribute("message","This username does not exist");
            }
            else {
            	resultSet.beforeFirst();
            	while(resultSet.next()) {
            		backend_pwd=resultSet.getString("password");
            		System.out.println(backend_pwd);
            	}
            	if(pwd.equals(backend_pwd)) 
                	isValid=true;
                else{
                	isValid=false;
                	session.setAttribute("message","Invalid credentials, please enter the details again");
                }
            }         
            if(isValid) {
				session.setAttribute("uname",uname);
				response.sendRedirect("welcome.jsp");
            }
            else 
            {
				request.setAttribute("touched",true);
				//we are using requestDispatcher because we want the same request object in the jsp page.
				//with sendRedirect() we get a new request object
				request.getRequestDispatcher("login.jsp").forward(request, response);
	//			response.sendRedirect("login.jsp");
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }		
	}

}
