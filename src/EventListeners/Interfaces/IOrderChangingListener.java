/**
 * IOrderChangingListener.java
 * Interface for objects that subscribe to the OrderChanging event
 * @author Justin W Walthers
 */
package EventListeners.Interfaces;

import Events.OrderChangingEvent;

public interface IOrderChangingListener
{
	public void orderChangingActionPerformed(OrderChangingEvent e);
}
