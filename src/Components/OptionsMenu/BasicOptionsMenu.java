package Components.OptionsMenu;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JPanel;
import Components.SizeMenu;
import EventListeners.Interfaces.IPizzaChangingListener;
import EventRaisers.NotifyPizzaChangingBase;
import EventListeners.PizzaChangingListener;
import Events.PizzaChangingEvent;


public class BasicOptionsMenu extends NotifyPizzaChangingBase
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1415068419467312284L;
	
	//REGION COMPONENTS
	private IPizzaChangingListener handler;
	private SizeMenu sizeMenu;
	private SauceOptionsMenu sauceMenu;
	private CheeseOptionsMenu cheeseMenu;
	private BakeOptionsMenu bakeMenu;
	
	//REGION CONSTRUCTORS
	public BasicOptionsMenu()
	{
		super(new BorderLayout());
		
		//construct the components and add to the layout
		handler = new PizzaChangingListener(this::onPizzaChanging);
		subscribers = new ArrayList<IPizzaChangingListener>();
		
		JPanel optionsPanel = new JPanel(new GridLayout(3, 1));
		
		sizeMenu = new SizeMenu();
		sauceMenu = new SauceOptionsMenu("Sauce");
		cheeseMenu = new CheeseOptionsMenu("Cheese");
		bakeMenu = new BakeOptionsMenu("Bake");
		
		sauceMenu.addPizzaChangingListener(handler);
		cheeseMenu.addPizzaChangingListener(handler);
		bakeMenu.addPizzaChangingListener(handler);
		sizeMenu.addPizzaChangingListener(handler);
		
		add(sizeMenu, BorderLayout.NORTH);
		optionsPanel.add(sauceMenu);
		optionsPanel.add(cheeseMenu);
		optionsPanel.add(bakeMenu);;
		add(optionsPanel, BorderLayout.WEST);
	}
	
	/**
	 * handle the PizzaChanging event by passing it up the chain of the GUI
	 * @param e The PizzaChanging event to handle
	 */
	private void onPizzaChanging(PizzaChangingEvent e)
	{
		raisePizzaChangingEvent(e);
	}

	public void resetControls()
	{
		sauceMenu.resetControls();
		sizeMenu.resetControls();
		cheeseMenu.resetControls();
		bakeMenu.resetControls();
		
	}

}
