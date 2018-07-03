package domain.login;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CartController(){}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			CartDao cartDao = new CartDaoImp();
			//String selectedEventId = request.getParameter("selectedEventId");
			//Event eventSelected = (Event) request.getSession().getAttribute(selectedEventId);

			//Event eventSelected = (Event) request.getSession().getAttribute(eventChosen);
			
			try {
				//Event eventSelected;
				Event eventSelected = new Event(Integer.parseInt(request.getParameter("eventId")),request.getParameter("topic"),request.getParameter("eventType"),new java.sql.Date ((new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("eventDate"))).getTime()),request.getParameter("location"),Float.parseFloat(request.getParameter("price")),request.getParameter("eventTime"),request.getParameter("description"));
				cartDao.addCartItem(eventSelected);
				request.setAttribute("eventsInCart", cartDao.getCartItems());
				request.getRequestDispatcher("cart.jsp").forward(request, response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			//eventSelected = new Event(111,"FoodBall Match","Sports",new java.sql.Date ((new SimpleDateFormat("yyyy/MM/dd").parse("2018/11/11")).getTime()),"UTD",(float) 0.00,"6:00pm","Match");




		}
		catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}


