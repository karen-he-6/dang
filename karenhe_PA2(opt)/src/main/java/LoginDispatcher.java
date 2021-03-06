import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
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
		
		
		try {
			
				 String db = "jdbc:mysql://localhost:3306/Program_2";
				 String user = "root";
		 		 String pwd = "karenhe105";
		 
		        Connection con = DriverManager.getConnection(db, user, pwd);
		        
		        
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			conn = DriverManager.getConnection("jdbc:mysql://localhost/Program_2?user=root&password=karenhe105"); //URI to mysql

			String sql = "SELECT * FROM UserInfo WHERE email=" + email + " AND pass_=" + password;
			PreparedStatement ps = con.prepareStatement(sql);
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
		

		if (error.equals("") == false && invalid) {
			request.setAttribute("error", error);
			request.setAttribute("invalid", "true");
			request.getRequestDispatcher("auth.jsp").forward(request, response);
		}
			
	
		else
		{
			request.setAttribute("invalid", "false");
			Cookie cookie1=new Cookie("name_", name);
			Cookie cookie2=new Cookie("email", email);
			response.addCookie(cookie1);
			response.addCookie(cookie2);
	        //request.getRequestDispatcher("HomePage.jsp").forward(request, response);
			response.sendRedirect("index.jsp");
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
