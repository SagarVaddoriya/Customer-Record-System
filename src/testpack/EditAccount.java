package testpack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class EditAccount
 */
@WebServlet("/EditAccount")
public class EditAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/EditAccount.jsp");
		rd.forward(request, response);	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		System.out.println(uid);
		String updatename = request.getParameter("updatename");
		String updatepass = request.getParameter("updatepass");
		DB_Access db = new DB_Access();
		boolean success = db.modifyUser(uid, updatename, updatepass);
		
		if(success)
		{
			response.sendRedirect("Login?msg=user modified");
		}
	}

}
