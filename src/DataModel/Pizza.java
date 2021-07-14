/**
 * Pizza.java
 * Represents a pizza at Quickman's Pizza
 * Stores information about the size, cheese, sauce, toppings, and bake of the pizza
 */
package DataModel;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import Enums.*;
import EventListeners.Interfaces.IPizzaChangedListener;
import EventRaisers.Interfaces.INotifyPizzaChanged;
import Events.PizzaChangedEvent;
import Events.PizzaChangingEvent;

public class Pizza implements INotifyPizzaChanged
{
	//REGION CONSTANTS
	private static final String formatString = "########Pizza Details########\n" + 
											   "Size: %1$s\n" + 
											   "Cheese: %2$s\n" + 
											   "Sauce: %3$s\n" + 
											   "Bake: %4$s\n" + 
											   "Toppings: %5$s\n" + 
											   "Price: %6$s\n" + 
											   "#############################\n";
	
	//REGION PRIVATE MEMBERS
	private PizzaSizes size;
	private CheeseInstruction cheese;
	private SauceInstruction sauce;
	private CookingInstruction cook;	
	private HashMap<String, PizzaTopping> toppings;
	private ArrayList<IPizzaChangedListener> subscribers;
	
	/**
	 * Creates a new instance of the Pizza object
	 * @param size the size option for the current instance
	 * @param cheese the cheese option for the current instance
	 * @param sauce the sauce option for the current instance
	 * @param cook the bake option for the current instance
	 * @param toppings the toppings for the current instance
	 */
	public Pizza()
	{
		toppings = new HashMap<String, PizzaTopping>();
		subscribers = new ArrayList<IPizzaChangedListener>();
		size = PizzaSizes.SMALL;
		cheese = CheeseInstruction.NORMAL;
		sauce = SauceInstruction.NORMAL;
		cook = CookingInstruction.NORMAL;
	}

	
	
	/**
	 * returns a string representation of the current instance
	 */
	public String toString()
	{
		NumberFormat dollar = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
		String priceStr = dollar.format(this.getPrice());
		ArrayList<String> toppingNames = new ArrayList<String>(this.toppings.size());
		
		this.toppings.values().forEach(t -> toppingNames.add(t.toString()));
		
		return String.format(formatString, this.size, this.cheese, this.sauce, this.cook, String.join(", ", toppingNames), priceStr);		
	}
	
	/**
	 * adds a single topping to the pizza
	 * @param t PizzaTopping
	 */
	public void changeTopping(PizzaTopping t, byte toppingChange)
	{
		//Rmove or add topping based on the nature of the change requested
		switch(toppingChange)
		{
			case PizzaChangingEvent.TOPPINGS_REMOVING:
				toppings.remove(t.getName());
				break;
			case PizzaChangingEvent.TOPPINGS_ADDING:
			case PizzaChangingEvent.TOPPINGS_CHANGING:
				toppings.put(t.getName(), t);
				break;
		}
		
		raisePizzaChangedEvent(new PizzaChangedEvent(this, t.getName(), true));
	}
	
	/**
	 * Gets the total price of the current pizza instance
	 * @return double
	 */
	public double getPrice()
	{
		double price = this.size.getBasePrice();
		
		for(PizzaTopping t: toppings.values())
			price += t.getPrice();
		
		return price;
	}
	
	/**
	 * sets the cheese parameter of the current instance
	 * @param cheese
	 */
	public void setCheeseInstruction(CheeseInstruction cheese)
	{
		if (this.cheese != cheese)
		{
			this.cheese = cheese;
			raisePizzaChangedEvent(new PizzaChangedEvent(this, cheese.toString(), false));
		}
	}
	
	/**
	 * sets the bake parameter of the current instance
	 * @param bake
	 */
	public void setBakeInstruction(CookingInstruction bake)
	{
		if (this.cook != bake)
		{
			this.cook = bake;
			raisePizzaChangedEvent(new PizzaChangedEvent(this, bake.toString(), false));
		}
	}
	
	/**
	 * sets the sauce parameter of the current instance
	 * @param sauce
	 */
	public void setSauceInstruction(SauceInstruction sauce)
	{
		if (this.sauce != sauce)
		{
			this.sauce = sauce;
			raisePizzaChangedEvent(new PizzaChangedEvent(this, sauce.toString(), false));
		}
	}
	
	/**
	 * sets the size parameter of the current instance
	 * @param size
	 */
	public void setSize(PizzaSizes size)
	{
		if (this.size != size)
		{
			this.size = size;
			raisePizzaChangedEvent(new PizzaChangedEvent(this, size.toString(), true));
		}
	}


	/**
	 * adds the provided listener to the list of subscribers to the PizzaChanged event
	 * @param l The PizzaChanged listener to remove
	 */
	@Override
	public void addPizzaChangedListener(IPizzaChangedListener l)
	{
		synchronized(this.subscribers)
		{
			if (!subscribers.contains(l))
				subscribers.add(l);
		}
		
	}


	/**
	 * removes the provided listener from the list of subscribers
	 * @param l The PizzaChanged listener to remove
	 */
	@Override
	public void removePizzaChangedListener(IPizzaChangedListener l)
	{
		synchronized(this.subscribers)
		{
			subscribers.remove(l);
		}
		
	}
	
	/**
	 * notifies all subscribers of the PizzaChanged event
	 * @param e The PizzaChanged event
	 */
	private void raisePizzaChangedEvent(PizzaChangedEvent e)
	{
		synchronized(this.subscribers)
		{
			subscribers.forEach(s -> s.actionPerformed(e));
		}
		
	}
}
