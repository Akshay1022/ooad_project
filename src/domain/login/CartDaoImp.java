package domain.login;

import java.util.ArrayList;
import java.util.List;

public class CartDaoImp implements CartDao{
	
	Cart cart = new Cart();
	

	@Override
	public int getEventsCount() {
		return cart.getEventsSelected().size();
	}

	@Override
	public void deleteCartItem(Event eventToBeDeleted) {
		List<Event> chosenEvents = cart.getEventsSelected();
		chosenEvents.remove(eventToBeDeleted);
		cart.setEventsSelected(chosenEvents);
		calculateOrderTotal();
		
	}

	@Override
	public void addCartItem(Event eventToBeAdded) {
		List<Event> chosenEvents = cart.getEventsSelected();
			chosenEvents.add(eventToBeAdded);
			cart.setEventsSelected(chosenEvents);
			calculateOrderTotal();
		}

	
	
	 public List<Event> getCartItems() {
		  return cart.getEventsSelected();
	}

	@Override
	public void calculateOrderTotal() {
		double total = 0;
		if(cart.getEventsSelected().size()!=0){
			for(Event event: cart.getEventsSelected()){
				total = total + event.getPrice();
			}
		}
		cart.setTotalCost(total);
		
	}

	@Override
	public double getOrderTotal() {
		return cart.getTotalCost();
	}
	
	
	

}
