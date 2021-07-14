package Components;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import DataModel.ToppingStarter;
import EventListeners.PizzaChangingListener;
import EventListeners.Interfaces.IPizzaChangingListener;
import EventRaisers.NotifyPizzaChangingBase;

public class ToppingsMenu extends NotifyPizzaChangingBase
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5170323509006401162L;
	private JLabel lbl_title;
	private ToppingsPanel pnl_meats;
	private ToppingsPanel pnl_nonMeats;
	private IPizzaChangingListener handler;
	
	//REGION CONSTANTS
	//These simulate toppings that would otherwise be loaded in from a database
	//The ToppingStarter object represents a simple data entity for pizza toppings
	private static final ToppingStarter[] meats = new ToppingStarter[]
	{new ToppingStarter("Pepperoni", false), new ToppingStarter("Sausage", false), new ToppingStarter("Bacon", false),
	 new ToppingStarter("Chorizo", true), new ToppingStarter("Bacon", false), new ToppingStarter("Ham", false), 
	 new ToppingStarter("Chicken", false), new ToppingStarter("Hamburger", false), new ToppingStarter("Meatballs", true),
	 new ToppingStarter("Capicola", true)};
	
	private static final ToppingStarter[] nonMeats = new ToppingStarter[]
	{new ToppingStarter("Extra Cheese", false), new ToppingStarter("Crumbled Feta", true), new ToppingStarter("Green Peppers", false),
	 new ToppingStarter("Olives", false), new ToppingStarter("Mushrooms", false), new ToppingStarter("Onions", false), 
	 new ToppingStarter("Pineapple", false), new ToppingStarter("Broccoli", true), new ToppingStarter("Roasted Tomatoes", true), 
	 new ToppingStarter("Roasted Garlic", true), new ToppingStarter("Peperoncini", false)};
	
	
	public ToppingsMenu()
	{
		//The Toppings menu will raise a PizzaChanging
		super(new BorderLayout());
		handler = new PizzaChangingListener(this::raisePizzaChangingEvent);
		subscribers = new ArrayList<IPizzaChangingListener>();
		
		JPanel pnl_title = new JPanel();
		pnl_meats = new ToppingsPanel("Meats", meats);
		pnl_meats.addPizzaChangingListener(handler);
		pnl_nonMeats = new ToppingsPanel("Non-Meats", nonMeats);
		pnl_nonMeats.addPizzaChangingListener(handler);
		
		//Set the layout and appearance
		this.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
		pnl_title.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.BLACK));
		
		//Construct and add the components
		lbl_title = new JLabel("Toppings (Premium toppings in red)");
		lbl_title.setForeground(new Color(204, 102, 0));
		pnl_title.add(lbl_title);	
		add(pnl_meats);
		add(pnl_nonMeats);
		this.add(pnl_title, BorderLayout.NORTH);
		this.add(pnl_meats, BorderLayout.WEST);
		this.add(pnl_nonMeats, BorderLayout.EAST);
		
	}

	public void resetControls()
	{
		pnl_meats.resetControls();
		pnl_nonMeats.resetControls();
		
	}
	
}
