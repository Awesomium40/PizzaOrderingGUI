/**
 * NotifyPizzaChangingBase.java
 * Extension of JPanel that raises the PizzaChanging event
 * @author Justin W Walthers
 */
package EventRaisers;

import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.JPanel;

import EventListeners.Interfaces.IPizzaChangingListener;
import EventRaisers.Interfaces.INotifyPizzaChanging;
import Events.PizzaChangingEvent;

public class NotifyPizzaChangingBase extends JPanel implements INotifyPizzaChanging
{

	private static final long serialVersionUID = -818729391359143245L;
	
	protected ArrayList<IPizzaChangingListener> subscribers;
	
	/**
	 * Creates a new instance of NotifyPizzaChangingBase
	 * @param l The layout manager to be used with the Panel
	 */
	public NotifyPizzaChangingBase(LayoutManager l)
	{
		super(l);
		subscribers = new ArrayList<IPizzaChangingListener>();
	}

	/**
	 * Creates a new instance of NotifyPizzaChangingBase
	 */
	public NotifyPizzaChangingBase()
	{
		super();
		subscribers = new ArrayList<IPizzaChangingListener>();
	}

	/**
	 * Adds a subscriber to the PizzaChanging event
	 * @param l: IPizzaChangingListener to add
	 */
	@Override
	public void addPizzaChangingListener(IPizzaChangingListener l)
	{
		synchronized(this.subscribers)
		{
			if (!subscribers.contains(l))
				subscribers.add(l);
		}
	}

	/**
	 * Removes a subscriber from the PizzaChanging event
	 * @param l: IPizzaChangingListener to remove
	 */
	@Override
	public void removePizzaChangingListener(IPizzaChangingListener l)
	{
		synchronized(this.subscribers)
		{
			this.subscribers.remove(l);
		}
	}
	
	/**
	 * Raises the PizzaChanging event to all listeners
	 * @param e the PizzaChanging event to raise
	 */
	protected void raisePizzaChangingEvent(PizzaChangingEvent e)
	{
		synchronized(this.subscribers)
		{
			subscribers.forEach(s -> s.pizzaChangingActionPerformed(e));
		}		
	}
}
