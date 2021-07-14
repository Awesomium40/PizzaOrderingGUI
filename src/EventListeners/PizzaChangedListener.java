/**
 * PizzaChangedListener.java
 * Base class for objects that consume the PizzaChanged event
 * @author Justin W Walthers
 */
package EventListeners;
import java.util.function.Consumer;
import EventListeners.Interfaces.IPizzaChangedListener;
import Events.PizzaChangedEvent;
public class PizzaChangedListener implements IPizzaChangedListener
{

	//Reference to method that handles the event
	private Consumer<PizzaChangedEvent> method;
	
	public PizzaChangedListener(Consumer<PizzaChangedEvent> method)
	{
		if (method == null)
			throw new NullPointerException("method");
		this.method = method;
	}
	
	@Override
	public void actionPerformed(PizzaChangedEvent e)
	{
		method.accept(e);
	}

}
