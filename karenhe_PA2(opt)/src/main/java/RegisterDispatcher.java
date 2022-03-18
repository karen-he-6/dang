import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


//import Util.Helper;

/**
 * Servlet implementation class RegisterDispatcher
 */
@WebServlet("/RegisterDispatcher")
public class RegisterDispatcher extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    private static final String url = "jdbc:mysql://localhost:3306/PA4Users";

    /**
     * Default constructor.
     */
    public RegisterDispatcher() {
    	super();
    }


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //TODO
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        //doGet(request, response);
    	
      //Step 1: set the content type
      		response.setContentType("text/html");
      		
      		//Step 2: get the printwriter
      		PrintWriter out = response.getWriter();
      		
      		//Step 3: generate the HTML content
      		//	
      		/* Register */
	      	//
      			boolean sendBack = false;
      			
      			
      			String userEmail = request.getParameter("registerEmail");
//      			if (!Helper.isValidEmail(userEmail))
//      			{
//      				String emailError = "<p> Invalid Email</p>";
//      				request.setAttribute("emailError", emailError);
//      				sendBack = true;
//      			}
//      			
          		
      			
      			
	      		String name = (String) request.getParameter("name");
	      		//see if name is empty
	      	
	      		
//	      		if (name.equals(""))
//	    		{
//	    			String errorName = "<p>Name Field Required</p>";
//	    			request.setAttribute("NameError", errorName);
//	    			sendBack = true;
//	    		}
//	      		else if (!Helper.validName(name))
//	    		{
//	    			String errorName = "<p> Invalid Name</p>";
//	    			request.setAttribute("NameError", errorName);
//	    			sendBack = true;
//	    		}
	      		String password = (String) request.getParameter("registerPassword");
	      		String confirmPassword = (String) request.getParameter("confirmPassword");
	      		if (confirmPassword == null) confirmPassword = "";
	      		if (password == null) password = "";
	      		
	      		if(password.equals("") || confirmPassword.equals(""))
	      		{
	      			sendBack = true;
	      			if (password.equals(""))
	      			{
	      				String missingPasswordError = "<p> Password Field Requried </p>";
	      				request.setAttribute("passwordError", missingPasswordError);
	      			}
	      			if (confirmPassword.equals(""))
	      			{
	      				String missingConfirmPasswordError = "<p> Conform Password Field Requried </p>";
	      				request.setAttribute("confirmPasswordError", missingConfirmPasswordError);
	      			}
	      		}else if (!password.equals(confirmPassword))//check password and confirm password match
	      		{
	      			String mismatchError = "<p> Password does not match Confirm Password</p>";
	      			request.setAttribute("mismatch", mismatchError);
	      			sendBack = true;
	      		}
	      		//confirm user selected check box
	      		if (request.getParameter("agree") == null)
	      		{
	      			String noAgree = "<p>You must Agree to SalEats Terms of Service to Create an Account</p>";
	      			request.setAttribute("noAgree", noAgree);
	      			sendBack = true;
	      		}
	      		
	      		System.out.println("About to register...");
	      		if (sendBack)
	      		{
	      			request.getRequestDispatcher("/auth.jsp").include(request, response);
	      		}else
	      		{
	      			try
	      			{
	      				Class.forName("com.mysql.jdbc.Driver");
	      			}catch (Exception e){
	      				System.out.println("could not add registered info to database");
	      			}
	      			
	      			
	      			System.out.println("We should be registering here");
	      			System.out.println(userEmail);
	      			System.out.println(name);
	      			System.out.println(password);
	      			
	      			String db = "jdbc:mysql://localhost/Program_2";
	      			String user = "root";
	      			String pwd = "karenhe105";
	      			String sql = "INSERT INTO UserInfo(email, name_, pass_)"
	      					+ "VALUES (?, ? ,?)";
	      			try (Connection conn = DriverManager.getConnection(db, user, pwd);
	      			PreparedStatement ps = conn.prepareStatement(sql);){
	      			ps.setString(1, userEmail);
	      			ps.setString(2, name);
	      			ps.setString(3, password);
	      			int row = ps.executeUpdate();
	      			System.out.println(
	      			String.format("Number of rows affected %d", row));
	      			}catch (SQLException ex) {
	      			System.out.println ("SQLException: " + ex.getMessage());}
	      			request.getRequestDispatcher("/index.jsp").include(request, response);
	      		}
    }

}



//
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//
//import java.sql.*;
//import java.io.*;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.io.Serial;
//
///**
// * Servlet implementation class RegisterDispatcher
// */
//@WebServlet("/RegisterDispatcher")
//public class RegisterDispatcher extends HttpServlet {
//    @Serial
//    private static final long serialVersionUID = 1L;
//    private static final String url = "jdbc:mysql://localhost:3306/PA4Users";
//
//    /**
//     * 
//     * Default constructor.
//     */
//    public RegisterDispatcher() {
//    	super();
//    }
//
//    
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String email = request.getParameter("registerEmail");
//		String username = request.getParameter("name");
//		String password = request.getParameter("registerPassword");
//		String confirmation = request.getParameter("confirmPassword");
//		String agree = request.getParameter("agree");
//		String error = "";
//		PrintWriter pw = response.getWriter();
//		boolean anyErrors = false;
//		boolean exists = false;
//		boolean success = false;
//		
//		//check for empty inputs and invalid email extensions
//		if(!(email.contains(".com") || email.contains(".org") || email.contains(".net") || email.contains(".edu"))) {			
//			error = "Enter a valid email";
//			anyErrors = true;
//		}
//		if(!confirmation.equals(password)) {
//			error = "password and confirmed password don't match";
//			anyErrors = true;
//		}
//		if(agree == "") {
//			error = "check off agreed box";
//			anyErrors = true;
//		}
//		
//		request.setAttribute("error", error);
//	//		request.getSession().setAttribute("user_id", user_id);
//		//check to see if username or email already exists in our database
//		Connection conn = null;
//		Statement st = null;
//		ResultSet rs = null;
//	
//   	 String db = "jdbc:mysql://localhost/Program_2";
//		String user = "root";
//		 String pwd = "karenhe105";
//
//		if(!anyErrors) {
//			try { //if user exists already
//				Class.forName("com.mysql.jdbc.Driver");
//		         conn = DriverManager.getConnection(db, user, pwd);
//				rs = st.executeQuery("SELECT u.email FROM UserInfo u WHERE u.email='" + email+ "'");
//				while(rs.next()) {
//					String tempemail = rs.getString("email");
//					if(tempemail.equals(email)) {
//						error = "This email already exists in our database.";
//						exists = true;
//					}
//				}
//			} catch (SQLException sqle){
//				System.out.println("sqle: " + sqle.getMessage());
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			
//		}
//		//if everything is good ... create user(now logged in)
//		if(!anyErrors && !exists ) {
////			conn = null;
////			st = null;
////			try {
////				 conn = DriverManager.getConnection(db, user, pwd);
////				st = conn.createStatement();
////				st.executeUpdate("INSERT INTO UserInfo (email, name_, pass_) VALUES ('"
////				+ email + "', '" + username + "', '" + password + "')");
////				//System.out.println("successfully registered user to the database");
////				success = true;
////			} catch (SQLException sqle){
////				System.out.println("sqle: " + sqle.getMessage());
////			}
//
//			
//			
//			PreparedStatement ps;
//			try
//  			{
//  				Class.forName("com.mysql.jdbc.Driver");
//  			}catch (Exception e){
//  				System.out.println("could not add registered info to database");
//  			}
//			
//			try {
//				
//						ps = conn.prepareStatement("INSERT INTO UserInfo (email, name_, pass_) VALUES (?, ?, ?)");
//						ps.setString(1, email);
//						ps.setString(2, username);
//						ps.setString(3, password);
//						ps.executeUpdate();
//					
//				
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			
////  			String sql = "INSERT INTO UserInfo(email, name_, pass_)"
////  					+ "VALUES (?, ? ,?)";
////  			try {
////  				Class.forName("com.mysql.jdbc.Driver");
////  				conn = DriverManager.getConnection(db, user, pwd);
////	  			PreparedStatement ps = conn.prepareStatement(sql);
////	  			ps.setString(1, email);
////	  			ps.setString(2, username);
////	  			ps.setString(3, password);
////	  			ps.executeUpdate();
////  		
////  			//String.format("Number of rows affected %d", row));
////  			}catch (SQLException ex) {
////  			System.out.println ("SQLException: " + ex.getMessage());} 
////  			catch (ClassNotFoundException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
//  			request.getRequestDispatcher("index.jsp").include(request, response);
//  			//response.sendRedirect("/index.jsp");
////			RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/index.jsp");
////			dispatch.forward(request, response);
//  		
//			
//		}
//	
//		if(success) {
//			//if the user is successfully created... create a session variable!
//			
////			HttpSession session = request.getSession();
////			session.setAttribute("username", username);
//			String name = "";
//			try {
//				name = rs.getString("name_");
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			String email1 = "";
//			try {
//				email1 = rs.getString("email");
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			Cookie cookie1 = new Cookie("name", name);
//			Cookie cookie2 = new Cookie("email", email); //turn cookies from spaces
//			response.addCookie(cookie2);
//			response.addCookie(cookie1);
//			response.sendRedirect("/index.jsp");
//			
//			
////			RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/index.jsp");
////			dispatch.forward(request, response);
//		}
//		
//	}
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}
//}
//
//       