package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name = request.getParameter("user_name");
		String password = request.getParameter("user_pass");
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_reg","root","root");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from users");
			PrintWriter out = response.getWriter();
			while(rs.next()) {
				String dbName = rs.getString(1);
				String dbPass = rs.getString(2);
				
				if(name.equals(dbName) && password.equals(dbPass)) {
					response.sendRedirect("Home.html");
					
				}
					
			}
			out.print("User not Registered! ");
			
		
		
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
	}

	
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
