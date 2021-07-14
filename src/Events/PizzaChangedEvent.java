/**
 * PizzaChangedEvent.java
 * Event that triggers after a change to a pizza has been finalized
 * @author Justin W Walthers
 */
package Events;
import java.awt.event.ActionEvent;

public class PizzaChangedEvent extends ActionEvent
{
	private boolean hasPriceChanged;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1253417584812781886L;

	/**
	 * Creates a new PizzaChangedEvent
	 * @param source The control that raised the event
	 * @param cmd the name of the command which triggered the event
	 * @param priceChanged Whether the price of the pizza changed
	 */
	public PizzaChangedEvent(Object source, String cmd, boolean priceChanged)
	{
		super(source, ActionEvent.ACTION_PERFORMED, cmd);
		
		hasPriceChanged = priceChanged;
	}
	
	public boolean hasPriceChanged()
	{
		return hasPriceChanged;
	}

}
