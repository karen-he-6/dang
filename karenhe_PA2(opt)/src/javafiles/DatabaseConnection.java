import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
  
// This class can be used to initialize the database connection
public class DatabaseConnection {
    protected static Connection initializeDatabase()
        throws SQLException, ClassNotFoundException
    {
    	
    	 String db = "jdbc:mysql://localhost/Program_2";
 		String user = "root";
 		 String pwd = "karenhe105";
 		String sql = "SELECT * FROM User";
       // String dbURL = "jdbc:mysql:// localhost:3306/";
        // Database name to access
        
        //Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(db, user, pwd);
        
        return con;
    	
//        String db = "jdbc:mysql://localhost/Program_2";
//		String user = "root";
//		 String pwd = "karenhe105";
//		String sql = "SELECT * FROM User";
//		try (Connection conn = DriverManager.getConnection(db, user, pwd);
//		Statement st = conn.createStatement();
//		 ResultSet rs = st.executeQuery(sql);) {
//		 while (rs.next())
//		 System.out.println (
//		 rs.getString("email") + "\t" +
//		 rs.getString("password")  );
//		 } catch (SQLException ex) {
//		 System.out.println ("SQLException: " + ex.getMessage());}
//		 }
    	 
    }
    
}