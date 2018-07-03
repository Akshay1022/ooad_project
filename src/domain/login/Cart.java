package domain.login;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	public List<Event> eventsSelected = new ArrayList<>();
	public double totalCost;
	
	public List<Event> getEventsSelected() {
		return eventsSelected;
	}
	public void setEventsSelected(List<Event> eventsSelected) {
		this.eventsSelected = eventsSelected;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	

}
