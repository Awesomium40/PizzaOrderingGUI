/**
 * OrderChangingListener.java
 * Base class for objects that listen to the OrderChanging event
 * @author Justin
 */
package EventListeners;
import java.util.function.Consumer;
import EventListeners.Interfaces.IOrderChangingListener;
import Events.OrderChangingEvent;

public class OrderChangingListener implements IOrderChangingListener
{

	//Reference to the Method that actually handles the event
	private Consumer<OrderChangingEvent> method;
	
	public OrderChangingListener(Consumer<OrderChangingEvent> method)
	{
		if (method == null)
			throw new NullPointerException("method");
		
		this.method = method;
	}
	
	@Override
	public void orderChangingActionPerformed(OrderChangingEvent e)
	{
		method.accept(e);
	}

}
