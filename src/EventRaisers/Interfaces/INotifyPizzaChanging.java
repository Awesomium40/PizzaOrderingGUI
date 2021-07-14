/**
 * INotifyPizzaChangingListener.java
 * Interface for objcts that raise the PizzaChanging event
 * @author Justin W Walthers
 */
package EventRaisers.Interfaces;

import EventListeners.Interfaces.IPizzaChangingListener;

public interface INotifyPizzaChanging
{
	void addPizzaChangingListener(IPizzaChangingListener l);
	void removePizzaChangingListener(IPizzaChangingListener l);
}
