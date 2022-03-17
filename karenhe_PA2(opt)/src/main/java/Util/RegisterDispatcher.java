package Util;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import java.sql.*;
import java.io.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.util.regex.Pattern;
import Util.Helper;

/**
 * Servlet implementation class RegisterDispatcher
 */
@WebServlet("/RegisterDispatcher")
public class RegisterDispatcher extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    private static final String url = "jdbc:mysql://localhost:3306/PA4Users";

    /**
     * 
     * Default constructor.
     */
    public RegisterDispatcher() {
    	super();
    }

    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("registerEmail");
		String username = request.getParameter("name");
		String password = request.getParameter("registerPassword");
		String confirmation = request.getParameter("confirmPassword");
		PrintWriter pw = response.getWriter();
		boolean anyErrors = false;
		boolean exists = false;
		boolean success = false;
		
		//check for empty inputs and invalid email extensions
		if(email.isEmpty() || !(email.contains(".com") || email.contains(".org") || email.contains(".net") || email.contains(".edu"))) {			
			pw.println("<p>Enter a valid email</p>");
			anyErrors = true;
		}
		if(username.isEmpty()) {
			pw.println("<p>Enter a username</p>");
			anyErrors = true;
		}
		if(password.isEmpty()) {
			pw.println("<p>Enter a password</p>");
			anyErrors = true;
		}
		if(confirmation.isEmpty() && !password.isEmpty()) {
			pw.println("<p>Please confirm your password</p>");
			anyErrors = true;
		}
		if(!confirmation.isEmpty() && !password.isEmpty() && !confirmation.equals(password)) {
			pw.println("<p>Your passwords do not match</p>");
			anyErrors = true;
		}
		//check to see if username or email already exists in our database
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		if(!anyErrors) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = (Connection) new DatabaseConnection();
				rs = st.executeQuery("SELECT u.email FROM UserInfo u WHERE u.email='" + email+ "'");
				while(rs.next()) {
					String tempemail = rs.getString("email");
					if(tempemail.equals(email)) {
						pw.println("<p>This email already exists in our database.</p>");
						exists = true;
					}
				}
			} catch (SQLException sqle){
				System.out.println("sqle: " + sqle.getMessage());
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		//if everything is good ... create user(now logged in)
		if(!anyErrors && !exists ) {
			conn = null;
			st = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn =(Connection) new DatabaseConnection();
				st = conn.createStatement();
				st.executeUpdate("INSERT INTO UserInfo (email, name_, pass_) VALUES ('"
				+ email + "', '" + username + "', '" + password + "')");
				//System.out.println("successfully registered user to the database");
				success = true;
			} catch (SQLException sqle){
				System.out.println("sqle: " + sqle.getMessage());
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	
		if(success) {
			//if the user is successfully created... create a session variable!
			
//			HttpSession session = request.getSession();
//			session.setAttribute("username", username);
			String name = "";
			try {
				name = rs.getString("name_");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String email1 = "";
			try {
				email1 = rs.getString("email");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Cookie cookie1 = new Cookie("name", name);
			Cookie cookie2 = new Cookie("email", email1);
			response.addCookie(cookie2);
			response.addCookie(cookie1);
			response.sendRedirect("index.jsp");
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

       