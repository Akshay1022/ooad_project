package domain.login;

public class SearchObject {
	String[] eventType;
	String[] eventDate;
	String[] eventPrice;
	
	public SearchObject(){
		
	}
	
	public SearchObject(String[] eventType, String[] eventDate, String[] eventPrice) {
		super();
		this.eventType = eventType;
		this.eventDate = eventDate;
		this.eventPrice = eventPrice;
	}
	public String[] getEventType() {
		return eventType;
	}
	public void setEventType(String[] eventType) {
		this.eventType = eventType;
	}
	public String[] getEventDate() {
		return eventDate;
	}
	public void setEventDate(String[] eventDate) {
		this.eventDate = eventDate;
	}
	public String[] getEventPrice() {
		return eventPrice;
	}
	public void setEventPrice(String[] eventPrice) {
		this.eventPrice = eventPrice;
	}

}
