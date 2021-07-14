/**
 * INotifyOrderChanging.java
 * Interface for objects that raise the OrderChanging event
 * @author Justin W Walthers
 */
package EventRaisers.Interfaces;

import EventListeners.Interfaces.IOrderChangingListener;

public interface INotifyOrderChanging
{
	public void addNotifyOrderChangingListener(IOrderChangingListener l);
	public void removeNotifyOrderChangingListener(IOrderChangingListener l);
}
