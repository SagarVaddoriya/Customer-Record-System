package testpack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddItems")
public class AddItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/addItems.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("iname");
		int qty = Integer.parseInt(request.getParameter("iq"));
		Integer uid = (Integer) request.getSession().getAttribute("uid");
		
		Item i = new Item(-1, name, qty, uid);
		
		DB_Access db = new DB_Access();
		db.insertItem(i);
		response.sendRedirect("Home?msg=item is successfully inserted");
	}

}
