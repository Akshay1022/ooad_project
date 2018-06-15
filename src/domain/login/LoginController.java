package domain.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginController() {}
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentDao studentDao = new StudentDaoImpl();
		EventDao eventsDao = new EventsDaoImp();
		
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		String submitType = request.getParameter("submit");
		
		if(email.equals("root") && pass.equals("akshay")){
			HttpSession session = request.getSession();
			session.setAttribute("user", "root");
			//setting session to expiry in 30 mins
			session.setMaxInactiveInterval(30*60);
			Cookie userName = new Cookie("user", email);
			userName.setMaxAge(30*60);
			response.addCookie(userName);
			response.sendRedirect("admin.jsp");
		}
		else{
			Login login = new Login(email, pass);
			Student c = studentDao.validateStudent(login);
			
			List<Event> fetchedEvents = eventsDao.getCurrentEvents();
		
			if(submitType.equals("login") && c!=null){
				HttpSession session = request.getSession();
				session.setAttribute("user", c.getEmail());
				//setting session to expiry in 30 mins
				session.setMaxInactiveInterval(30*60);
				Cookie userName = new Cookie("user", email);
				userName.setMaxAge(30*60);
				response.addCookie(userName);
				
				request.setAttribute("message", "Hello "+c.getEmail());
				
				request.setAttribute("events", fetchedEvents);
				request.getRequestDispatcher("welcome.jsp").forward(request, response);
			
			}
			else{
				request.setAttribute("message", "Data Not Found! Please register!");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}

		}
	
	}

}
