/**
 * IPizzaChangedListener.java
 * INterface for objects that subscribe to the PizzaChanged event
 * @author Justin W Walthers
 */
package EventListeners.Interfaces;

import Events.PizzaChangedEvent;

public interface IPizzaChangedListener
{
	public void actionPerformed(PizzaChangedEvent e);
}
