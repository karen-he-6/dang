package Util;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.Serial;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class LoginDispatcher
 */
@WebServlet("/LoginDispatcher")
public class LoginDispatcher extends HttpServlet {
  
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            
    	throws ServletException, IOException {
    	response.setContentType("text/html");
    	String error = "";
    	String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = "";
		Boolean invalid = false;
		HttpSession session = request.getSession();
		System.out.println(email + " " + password);
		
		//get an instance of JDBC driver
		Connection conn = null;
		
		try {
			
			conn = (Connection) new DatabaseConnection();
			String sql = "SELECT * FROM UserInfo WHERE email=" + email + " AND pass_=" + password;
			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, email);
//			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			//check if email and pass are present in database
			if(rs.next())
			{
				if(rs.getRow() > 0)
				{
					request.setAttribute("invalid", "false");
					invalid = false;
					//find user's name
					name = rs.getString(1);
				}
				else
				{
					request.setAttribute("invalid", "true");
					invalid = true;
					error = "invalid email or password ";
				}
			}
			else
			{
				request.setAttribute("invalid", "true");
				invalid = true;
				error = "invalid email or password ";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		if (email.contentEquals(""))
		{
			error += "email missing ";
			invalid = true;
		}
		if (password.contentEquals(""))
		{
			error += "password missing ";
			invalid = true;
		}
		

		if (error.equals("") && !invalid)
		{
			request.setAttribute("invalid", "false");
			Cookie cookie1=new Cookie("name_", name);
			Cookie cookie2=new Cookie("email", email);
			response.addCookie(cookie1);
			response.addCookie(cookie2);
	        //request.getRequestDispatcher("HomePage.jsp").forward(request, response);
			response.sendRedirect("HomePage.jsp");
		}
		else
		{
			request.setAttribute("error", error);
			request.setAttribute("invalid", "true");
			request.getRequestDispatcher("auth.jsp").forward(request, response);
		}
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
