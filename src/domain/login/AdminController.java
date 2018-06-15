package domain.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DbManager;

@WebServlet("/AdminController")
public class AdminController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
	
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html");
    	String submitType = request.getParameter("submit");
    	Cookie[] cookies = request.getCookies();
    	if(cookies != null){
    	for(Cookie cookie : cookies){
    		if(cookie.getName().equals("JSESSIONID")){
    			System.out.println("JSESSIONID="+cookie.getValue());
    			break;
    		}
    	}
    	
    	
    
		
    if(submitType.equals("add_event")){
    	
    	EventDao eventModifier = new EventsDaoImp();
    	
    	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd");
    	java.util.Date date;
		try {
			date = sdf1.parse(request.getParameter("date"));
		
    	java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
    	Event eventobject = new Event(0,request.getParameter("title"),request.getParameter("type"),sqlStartDate,request.getParameter("loc"),Float.parseFloat(request.getParameter("price")),request.getParameter("time"),request.getParameter("desc") );
    	eventModifier.addEvent(eventobject);
    //	addEvents(ae);
    //	request.getRequestDispatcher("admin.jsp");
    	response.sendRedirect("admin.jsp");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    	}
    	else
    	{
    		response.sendRedirect("login.jsp");
    	}
    
    }
    
    

}
