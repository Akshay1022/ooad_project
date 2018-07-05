package domain.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DbManager;

@WebServlet("/SearchController")
public class SearchController extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//SearchObject filtered = new SearchObject();
		List<Event> listCurrentEvents = new ArrayList<>();
		String events[] = request.getParameterValues("type");
		String date[] = request.getParameterValues("date");
		String price[] = request.getParameterValues("price");
		System.out.println(events);
		String eventss = null;
		try{
			
			
//			if(events[0] != null )
//			eventss = events[0];
//			if(events[1] != null)
//			eventss = eventss + " or " + events[1];
//			if(events[2] != null)
//			eventss = eventss + "or" + events[2];
			
			conn = db.getConnection();
			String q = "select * from events where";
			
			if(events!=null){
			for(int i=0; i<events.length; i++){
				if(events[i] != null)
					if(i==0)
					q = q + " (EventType = ?";
					else if(i>0 )
						q = q + " or EventType = ? ";
			}		
			q = q + "  ) ";			
			}
			
			String q2 = q;
	//		if (events==null || price==null)
	//			q2 =q2 + "here";
			if (events!=null && price!=null)
				q2 += " and ";
			if(price!=null){
			for(int i=0; i<price.length; i++){
				if(price[i] != null)
					q2 = q2 + " price <= ? or ";
			}
			q2 = q2.substring(0, q2.length()-4);
		}
			
			String q3 = q2;
			if (events==null && price==null && date!=null)
				q3 = "select * from events ORDER BY EventDate ASC";
			if ( date !=null){
				if(events==null && price==null){
					q3 = q3.substring(0, q2.length()-5);
				q3 += " ORDER BY EventDate ASC";
				}
			}
			
			ps =conn.prepareStatement(q3);
			int count = 0;
			if(events!=null){	
			for(int i=0; i<events.length; i++){
				ps.setString(i+1, events[i]);
				count=i+1;
			}
		}
			if(price!=null){
			for(int i=0; i<price.length; i++){
				ps.setString(count+1, price[i]);
				count++;
			}
			}
			
			
			//ps.setString(2, login.getPassword());

			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Event event = new Event();
				event.setEventId(rs.getInt(1));
				event.setTopic(rs.getString(2));
				event.setEventType(rs.getString(3));
				event.setEventDate(rs.getDate(4));
				event.setLocation(rs.getString(5));
				event.setPrice(rs.getFloat(6));
				event.setEventTime(rs.getString(7));
				event.setDescription(rs.getString(8));
				listCurrentEvents.add(event);
			}
			
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		HttpSession session = request.getSession();
		Student stu = (Student) session.getAttribute("user");
		request.setAttribute("message", "Hello"+" " + stu.getEmail());
		request.setAttribute("events", listCurrentEvents);
		request.getRequestDispatcher("welcome.jsp").forward(request, response);
		//filtered.setEventType(events);
		//filtered.setEventDate(date);
		//filtered.setEventPrice(price);

	}
	
}
