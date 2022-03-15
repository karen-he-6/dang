import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;

/**
 * Servlet implementation class GoogleDispatcher
 */
public class GoogleDispatcher extends HttpServlet {
	
    @Serial
    private static final long serialVersionUID = 1L;

    
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String username = request.getParameter("loginUsername");
		String email = request.getParameter("loginEmail");
		System.out.print("hi " + username);
		
//		JDBCTest.initConnection();
//		//out.flush();
//		
//
//		if(!JDBCTest.usernameExist(username)) { // Username does not exist
//			JDBCTest.addUser(username, email, "123", "yes");
//		}

	}
@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
