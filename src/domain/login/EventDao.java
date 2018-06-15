package domain.login;

import java.util.List;


public interface EventDao {
	
	public List<Event> getCurrentEvents();
	
	public int addEvent(Event event);

}
