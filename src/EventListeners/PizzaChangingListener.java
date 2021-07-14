/**
 * PizzaChangingListener.java
 * Base class for classes that consume the PizzaChanging event
 * @author Justin W Walthers
 */
package EventListeners;
import java.util.function.Consumer;

import EventListeners.Interfaces.IPizzaChangingListener;
import Events.OrderChangingEvent;
import Events.PizzaChangingEvent;

public class PizzaChangingListener implements IPizzaChangingListener
{

	//Reference to the method that handles the event
	private Consumer<PizzaChangingEvent> method;
	
	public PizzaChangingListener(Consumer<PizzaChangingEvent> method)
	{
		if (method == null)
			throw new NullPointerException("method");
		this.method = method;
	}
	
	@Override
	public void pizzaChangingActionPerformed(PizzaChangingEvent e)
	{
		method.accept(e);
	}

}
