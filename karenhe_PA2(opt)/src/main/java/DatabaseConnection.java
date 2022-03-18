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
 
        Connection con = DriverManager.getConnection(db, user, pwd);
        
        return con;
    	

    	 
    }
    
}