package Components;
import javax.swing.*;
import Components.OptionsMenu.BasicOptionsMenu;
import Enums.CheeseInstruction;
import Enums.CookingInstruction;
import Enums.PizzaSizes;
import Enums.SauceInstruction;
import EventListeners.PizzaChangingListener;
import EventListeners.OrderChangingListener;
import EventListeners.PizzaChangedListener;
import Events.OrderChangingEvent;
import Events.PizzaChangedEvent;
import Events.PizzaChangingEvent;
import java.awt.*;
import DataModel.*;

public class OrderingWindow extends JFrame
{
	private ToppingsMenu tm;
	private BasicOptionsMenu bm;
	private OrderControlsPanel controlPanel;
	private PizzaChangingListener pizzaChangingListener;
	private PizzaChangedListener pizzaChangedListener;
	private OrderChangingListener orderChangingListener;
	private Order order;
	private Pizza pizza;
	private final String WINDOW_TITLE = "Quickman's Pizza: Guranteed Delivery in 30 minutes or you get a boomerang to the head";

	/**
	 * 
	 */
	private static final long serialVersionUID = 4441490244966397306L;

	
	/***
	 * Creates a new instance of the object
	 */
	public OrderingWindow()
	{
		this.order = new Order();
		this.pizza = new Pizza();
		
		//There are quite a few events that need to have responses. 
		//The GUI can be requesting a change to the pizza
		//The pizza can be reporting that a change has occurred
		//Orders can change as a pizza is added, and pizzas can be canceled
		this.pizzaChangingListener = new PizzaChangingListener(this::onPizzaChanging);
		this.pizzaChangedListener = new PizzaChangedListener(this::onPizzaChanged);
		this.orderChangingListener = new OrderChangingListener(this::onOrderChanging);
		this.pizza.addPizzaChangedListener(pizzaChangedListener);
		
		
		//The GUI is composed of 3 regions
		//Basic options (cheese, bake, sauce, size)
		//Toppings
		//Order controls
		tm = new ToppingsMenu();
		bm = new BasicOptionsMenu();
		controlPanel = new OrderControlsPanel();
		
		
		bm.addPizzaChangingListener(pizzaChangingListener);
		tm.addPizzaChangingListener(pizzaChangingListener);
		controlPanel.addNotifyOrderChangingListener(orderChangingListener);
		
		//Layout the controls along the edges of the window using a BorderLayout
		this.setLayout(new BorderLayout());
		this.add(tm, BorderLayout.WEST);
		this.add(bm, BorderLayout.NORTH);
		this.add(controlPanel, BorderLayout.SOUTH);
		this.setTitle(WINDOW_TITLE);
		
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		//Finally, start by initializing a new pizza for a customer's order
		onPizzaChanged(new PizzaChangedEvent(this, "create", true));

	}

	public static void main(String[] args)
	{
		new OrderingWindow();
	}
	
	/**
	 * Handles the PizzaChanged event by updating the pizza price if necessary
	 * @param e The PizzaChanged event to handle
	 */
	private void onPizzaChanged(PizzaChangedEvent e)
	{
		if (e.hasPriceChanged())
			this.controlPanel.updatePrice(this.pizza.getPrice());
	}
	
	/**
	 * Handles the PizzaChanging event by altering the Pizza Object
	 * @param e the PizzaChanging event to handle
	 */
	private void onPizzaChanging(PizzaChangingEvent e)
	{
		byte change = e.getRequestedChange();
		//The action to be taken depends on which property is being changed, and what change to that property is requested
		switch (e.getChangingProperty())
		{
			case PizzaChangingEvent.BAKE_CHANGING:
				pizza.setBakeInstruction(change == PizzaChangingEvent.LIGHT_BAKE ? CookingInstruction.LIGHT_BAKE : 
										 change == PizzaChangingEvent.NORMAL_BAKE ? CookingInstruction.NORMAL : 
											 CookingInstruction.WELL_DONE);
				break;
			case PizzaChangingEvent.CHEESE_CHANGING:
				pizza.setCheeseInstruction(change == PizzaChangingEvent.NO_CHEESE ? CheeseInstruction.NO_CHEESE : 
										   change == PizzaChangingEvent.LIGHT_CHEESE ? CheeseInstruction.LIGHT_CHEESE : 
										   CheeseInstruction.NORMAL);
				break;
			case PizzaChangingEvent.SAUCE_CHANGING:
				pizza.setSauceInstruction(change == PizzaChangingEvent.NO_SAUCE ? SauceInstruction.NO_SAUCE : 
										  change == PizzaChangingEvent.LIGHT_SAUCE ? SauceInstruction.LIGHT_SAUCE : 
										  change == PizzaChangingEvent.NORMAL_SAUCE ? SauceInstruction.NORMAL : 
											  SauceInstruction.EXTRA_SAUCE);
				break;
			case PizzaChangingEvent.SIZE_CHANGING:
				pizza.setSize(change == PizzaChangingEvent.SMALL_PIZZA ? PizzaSizes.SMALL : 
							  change == PizzaChangingEvent.LARGE ? PizzaSizes.LARGE : PizzaSizes.XLARGE);
				break;
			case PizzaChangingEvent.TOPPINGS_CHANGING:
			case PizzaChangingEvent.TOPPINGS_ADDING:
			case PizzaChangingEvent.TOPPINGS_REMOVING:
				pizza.changeTopping(e.getChangingTopping(), e.getRequestedChange());
		}
	}
	
	/**
	 * Handles the OrderChanging event by adding/canceling the current pizza as appropriate
	 * @param e the OrderChanging event to handle
	 */
	private void onOrderChanging(OrderChangingEvent e)
	{
		if (e.getAction() == OrderChangingEvent.ADDING)
			addPizzaToOrder();
		else if (e.getAction() == OrderChangingEvent.CANCEL)
			resetPizza();			
	}
	
	/**
	 * Resets the current pizza to its default state
	 */
	private void resetPizza()
	{
		pizza = new Pizza();
		pizza.addPizzaChangedListener(pizzaChangedListener);
		onPizzaChanged(new PizzaChangedEvent(this, "new", true));
		resetControls();
	}

	/**
	 * Adds the current pizza to the open order and creates a new default pizza as the current
	 */
	private void addPizzaToOrder()
	{
		order.addPizza(pizza);	
		updateOrderQuantity();
		showOrder();
		resetPizza();
	}
	
	/**
	 * Updates the text box that displays order quantity
	 */
	private void updateOrderQuantity()
	{
		this.controlPanel.updateQuantity(order.getQuantity());
	}
	
	/**
	 * Resets the Topping menu and basic menu controls to their default state
	 */
	private void resetControls()
	{
		tm.resetControls();
		bm.resetControls();
	}
	
	/**
	 * Displays the details of the current order in a new dialog
	 */
	private void showOrder()
	{
		JOptionPane.showMessageDialog(this, order.toString(), "Your Order", JOptionPane.INFORMATION_MESSAGE);
	}

}
