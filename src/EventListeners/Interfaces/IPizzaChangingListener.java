/**
 * IPizzaChangingListener.java
 * Interface for objects that subscribe to the PizzaChanging event
 */
package EventListeners.Interfaces;
import Events.PizzaChangingEvent;

public interface IPizzaChangingListener
{
	void pizzaChangingActionPerformed(PizzaChangingEvent e);
}
