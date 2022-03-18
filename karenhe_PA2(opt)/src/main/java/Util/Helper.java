package Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Helper {
    /**
     * check if name is valid
     *
     * @param name the name user provides
     * @return valid or not valid
     */
    public static boolean validName(String name) {
        return Constant.namePattern.matcher(name).matches();
    }

    /**
     * check if email is valid
     *
     * @param email the email user provides
     * @return valid or not valid
     */
    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        return Constant.emailPattern.matcher(email).matches();
    }

    /**
     * Get username with the email
     *
     * @param email
     * @return userName
     * @throws SQLException
     */
    public static String getUserName(String email) throws SQLException {
        //TODO
    	
    	String db = "jdbc:mysql://localhost/Program_2";
		String user = "root";
		String pwd = "karenhe105";	
		String sql = "SELECT u.name FROM UserInfo u WHERE u.email = \"" + email + "\"";
		
		try (Connection conn = DriverManager.getConnection(db, user, pwd);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);) {
		while (rs.next())
			return rs.getString("name");
	} catch (SQLException ex) {
		System.out.println ("SQLException: " + ex.getMessage());
	}
	
        return null;
    }

    /**
     * Get userID with email
     *
     * @param email
     * @return userID
     * @throws SQLException
     */
    public static int getUserID(String email) throws SQLException {
        //TODO
        return 0;
    }

    /**
     * check if the email and password matches
     *
     * @param email
     * @param password
     */
    public static boolean checkPassword(String email, String password) throws SQLException {
        //TODO
        return false;
    }

    /**
     * Check if email is already registered
     *
     * @param email
     * @param request
     * @param response
     * @return email registered or not
     * @throws ServletException
     * @throws IOException
     * @throws SQLException 
     */
    public static boolean emailAlreadyRegistered(String email, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
    	String db = "jdbc:mysql://localhost/Program_2";
		String user = "root";
		String pwd = "karenhe105";
		String emailquery = "SELECT * from UserInfo WHERE email = \"" + email + "\"";
    	try(Connection conn = DriverManager.getConnection(db, user, pwd)){
    	
    	
    	Statement st = conn.createStatement();
    	ResultSet rs = st.executeQuery(emailquery); // execute the query, and get a java resultset

    	// if this email already exists, we quit
    	if(rs.absolute(1)) {
    	     
    	     return true;
    	}
        return false;
    	}
		
    }
    

}
