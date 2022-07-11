package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserRegister() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("user_name");
		String password = request.getParameter("user_pass");
		String phone = request.getParameter("user_phone");
		String email = request.getParameter("user_email");
		
		System.out.println(name+" : "+password +" : "+ phone +" : "+ email);
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_reg","root","root");
			PreparedStatement stmt = con.prepareStatement("insert into users(name,password,phone,email) values(?,?,?,?)");
			
			
			stmt.setString(1, name);
			stmt.setString(2, password);
			stmt.setString(3, phone);
			stmt.setString(4, email);
			
			stmt.execute();
			
			response.sendRedirect("Home.html");
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
