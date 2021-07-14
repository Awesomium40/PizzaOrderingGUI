package EventListeners;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

/**
 * ButtonActionListener.java
 * A class which handles ActionEvents raised by various buttons
 * @author Justin
 *
 */
public class ButtonActionListener implements ActionListener
{
	private Consumer<ActionEvent> _eventMethod;
	
	public ButtonActionListener(Consumer<ActionEvent> method)
	{
		if (method == null)
			throw new NullPointerException("Parameter 'method' cannot be null");
		
		_eventMethod = method;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		_eventMethod.accept(e);		
	}

}
