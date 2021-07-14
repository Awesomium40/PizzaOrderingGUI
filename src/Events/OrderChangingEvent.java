/**
 * OrderChangingEvent.java
 * Event that triggers when an order is changed (Pizza added/canceled)
 * @author Justin W Walthers
 */
package Events;
import java.awt.event.ActionEvent;

public class OrderChangingEvent extends ActionEvent
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3004331440686244749L;
	public static final byte ADDING = 0;
	public static final byte CANCEL = 1;
	
	private byte action;

	/***
	 * Creates a new OrderChanging event
	 * @param source The control that raised the event
	 * @param action The change requested (add or cancel)
	 * @param cmd The name of the command associated with the event
	 */
	public OrderChangingEvent(Object source, byte action, String cmd)
	{
		super(source, ActionEvent.ACTION_PERFORMED, cmd);
		this.action = action;
	}
	
	public byte getAction()
	{
		return action;
	}

}
