package domain.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/DetailsController")
public class DetailsController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DetailsController(){}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String eventTopic = request.getParameter("topic");
		
		EventDao eventDetails = new EventsDaoImp();
		
		
		Event requiredEvent = eventDetails.getRequiredEvent(eventTopic);
		
		request.setAttribute("eventDetails", requiredEvent);
		request.getRequestDispatcher("event_details.jsp").forward(request, response);
	}
	
	
	
	

}