package Events;
import java.awt.event.ActionEvent;
import DataModel.PizzaTopping;

/**
 * PizzaChangingEvent
 * Event that fires when a menu panel requests a change to the pizza object
 * @author Justin W Walthers
 *
 */
public class PizzaChangingEvent extends ActionEvent
{
	//REGION public constants
	//These constants specify the nature of the change
	public static final byte SIZE_CHANGING = 0;
	public static final byte CHEESE_CHANGING = 1;
	public static final byte SAUCE_CHANGING = 2;
	public static final byte BAKE_CHANGING = 3;
	public static final byte TOPPINGS_ADDING = 4;
	public static final byte TOPPINGS_REMOVING = 5;
	public static final byte TOPPINGS_CHANGING = 6;
	
	//These constants specify what change in size is being requested
	public static final byte SMALL_PIZZA = 7;
	public static final byte LARGE = 8;
	public static final byte XLARGE = 9;
	
	//These constance specfy the change to the cheese property of the pizza
	public static final byte NO_CHEESE = 10;
	public static final byte LIGHT_CHEESE = 11;
	public static final byte NORMAL_CHEESE = 12;
	
	//These constants specify the change to the sauce property of the pizza
	public static final byte NO_SAUCE = 13;
	public static final byte LIGHT_SAUCE = 14;
	public static final byte NORMAL_SAUCE = 15;
	public static final byte EXTRA_SAUCE = 16;
	
	//These constants specify the change to the bake property of the pizza
	public static final byte LIGHT_BAKE = 17; 
	public static final byte NORMAL_BAKE = 18;
	public static final byte WELL_DONE_BAKE = 19;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2981653705370447883L;
	private byte changingProperty;
	private byte changeRequested;
	private PizzaTopping changingTopping;
	
	/**
	 * Creates a new instance of the PizzaChangingEvent - use when Base options are changing
	 * @param source the object that raised the event
	 * @param propertyChanging the property of the pizza that is changing - should be one of the predefined constants
	 * @param change the change requested - should be one of the predefined constants
	 * @param cmd the ActionCommand associated with this instance
	 */
	public PizzaChangingEvent(Object source, byte propertyChanging, byte change, String cmd)
	{
		super(source, ActionEvent.ACTION_PERFORMED, cmd);
		
		//Check for a value of the property being changed that is out of bounds
		if (propertyChanging > TOPPINGS_CHANGING || propertyChanging < SIZE_CHANGING)
		{
			throw new IllegalArgumentException("PropertyChanging must be one of the following:\n SIZE_CHANGING, CHEESE_CHANGING, SAUCE_CHANGING, BAKE_CHANGING");
		}
		//Check that the requested change is within the specified bounds
		else if (change < SMALL_PIZZA || change > WELL_DONE_BAKE)
		{
			throw new IllegalArgumentException("PropertyChanging must be one of the following; SMALL_PIZZA, MEDIUM_PIZZA, LARGE_PIZZA, NO_CHEESE, " + 
		"LIGHT_CHEESE, NORMAL_CHEESE, NO_SAUCE, LIGHT_SAUCE, NORMAL_SAUCE, EXTRA_SAUCE, LIGHT_BAKE, NORMAL_BAKE, WELL_DONE_BAKE");
		}
		//Ensure that a request for change in size is accompanied by a valid size specification
		else if (propertyChanging == SIZE_CHANGING && (change < SMALL_PIZZA || change > XLARGE))
		{
			throw new IllegalArgumentException("change in the size property requires a coresponding change parameter");
		}
		//Ensure that a request for change in cheese is accompanied by a valid cheese specification
		else if (propertyChanging == CHEESE_CHANGING && (change < NO_CHEESE || change > NORMAL_CHEESE))
		{
			throw new IllegalArgumentException("change in the cheese property requires a coresponding change parameter");
		}
		//Ensure that a request for a change in sauce is accompanied by a valid sauce specification
		else if (propertyChanging == SAUCE_CHANGING && (change < NO_SAUCE || change > EXTRA_SAUCE))
		{
			throw new IllegalArgumentException("change in the size property requires a coresponding change parameter");
		}
		//Ensure that a request for change in bake is accompanied by a valid bake specification
		else if (propertyChanging == BAKE_CHANGING && (change < LIGHT_BAKE || change > WELL_DONE_BAKE))
		{
			throw new IllegalArgumentException("change in the bake property requires a coresponding change parameter");
		}
		else
		{
			this.changingProperty = propertyChanging;
			this.changeRequested = change;
		}
		
	}
	
	/**
	 * Creates a new instance of the object - Use when topping is changing
	 * @param source the source of the event
	 * @param topping the PizzaTopping to be changed
	 * @param change the PizzaChangingEvent change constant to be made
	 * @param cmd the actioncommand
	 */
	public PizzaChangingEvent(Object source, PizzaTopping topping, byte change, String cmd)
	{
	
		super(source, ActionEvent.ACTION_PERFORMED, cmd);
		
		//Need to ensure that a request for change in topping is accompanied by an actual topping change parameter
		if (change < TOPPINGS_ADDING || change > TOPPINGS_CHANGING)
			throw new IllegalArgumentException("change in Topping requires a corresponding change parameter");
		
		changingProperty = change;
		changeRequested = change;
		
		this.changingTopping = topping;
		
	}
	
	/**
	 * gets the property of the pizza that is being changed
	 * @return byte
	 */
	public byte getChangingProperty()
	{
		return this.changingProperty;
	}

	/**
	 * gets the change that is requested for the property being modified
	 * @return byte
	 */
	public byte getRequestedChange()
	{
		return this.changeRequested;
	}
	
	public PizzaTopping getChangingTopping()
	{
		return this.changingTopping;
	}
}
