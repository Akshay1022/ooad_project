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
    	
    	AdminEvents ae = new AdminEvents(request.getParameter("title"),request.getParameter("desc"));
    	addEvents(ae);
    //	request.getRequestDispatcher("admin.jsp");
    	response.sendRedirect("admin.jsp");
    	
    }
    
    	}
    	else
    	{
    		response.sendRedirect("login.jsp");
    	}
    
    }
    
    public int addEvents(AdminEvents ae)
    {
    	int status = 0;
    	
		try{
			conn = db.getConnection();
			String query = "SELECT MAX(id) AS `maxid` FROM events";
			Statement st = conn.createStatement(); 
		    ResultSet rs = st.executeQuery(query);
		    int maxid=0;
		    while (rs.next())
		      {
		        maxid = rs.getInt("maxid");
		      }
		    
		    
			
			ps =conn.prepareStatement("insert into events values(?,?,?)");
	//		ps =conn.prepareStatement("INSERT INTO events (title, desc, id) VALUES (?, ?, ?)");
			ps.setString(1, ae.gettitle());
			ps.setString(2, ae.getdesc());
			ps.setInt(3, maxid+1);
			
			
			status = ps.executeUpdate();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
	
		return status;
    	
    }

}
