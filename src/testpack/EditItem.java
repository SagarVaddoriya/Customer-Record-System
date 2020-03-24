package testpack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/EditItem")
public class EditItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/EditItem.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DB_Access db = new DB_Access();
		HttpSession sess = request.getSession();
		String name = request.getParameter("iname");
		String qty = request.getParameter("iqty");
		int qtyy = Integer.parseInt(qty);
		int uid = (Integer) sess.getAttribute("uid");
		
		int iid = Integer.parseInt(request.getParameter("id"));
		db.removeProduct(iid);
	
		Item i = new Item(-1, name, qtyy, uid);
		db.insertItem(i);
		response.sendRedirect("Home");
	}

}
