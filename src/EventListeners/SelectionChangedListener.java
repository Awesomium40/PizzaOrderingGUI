/**
package EventListeners;
import java.util.function.Consumer;
import EventListeners.Interfaces.ISelectionChangedListener;
import Events.SelectionChangedEvent;

public class SelectionChangedListener implements ISelectionChangedListener
{
	private Consumer<SelectionChangedEvent> handler;

	public SelectionChangedListener(Consumer<SelectionChangedEvent> handler)
	{
		if(handler == null)
			throw new NullPointerException("handler");
			
		this.handler = handler;
	}
	@Override
	public void actionPerformed(SelectionChangedEvent e)
	{
		this.handler.accept(e);
	}

}
*/