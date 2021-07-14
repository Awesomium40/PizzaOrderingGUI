/**
 * ToppingsPanel.java
 * Justin W Walthers
 * Represents the controls which allow users to add/remove toppings from a pizza
 */
package Components;
import javax.swing.*;
import DataModel.ToppingStarter;
import EventListeners.PizzaChangingListener;
import EventListeners.Interfaces.IPizzaChangingListener;
import EventRaisers.NotifyPizzaChangingBase;
import java.awt.*;
import java.util.ArrayList;


public class ToppingsPanel extends NotifyPizzaChangingBase
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2118184848315161412L;
	
	//REGION PRIVATE COMPONENTS
	private ArrayList<ToppingSelector> selectors; // Controls that actually select the toppings
	private IPizzaChangingListener pizzaChangingHandler; //Event handler for PizzaChanging event
	private static final String[] columns = {"None", "Full", "<html>1st<br>Half", "<html>2nd<br>Half", "2X"};
	private static final Dimension HEADER_SIZE = new Dimension(100, 20);
	private static final Dimension LABEL_SIZE = new Dimension(35, 30);
	private static final GridBagConstraints HEADER_CONSTRAINTS = new GridBagConstraints(0, 0, 1, 1, .25, 0, GridBagConstraints.LINE_START, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
	
	//REGION CONSTRUCTORS
	/**
	 * Creates a new instance of the object
	 * @param panelName the name for the current panel instance
	 * @param toppings The toppings for the current panel
	 */
	public ToppingsPanel(String panelName, ToppingStarter[] toppings)
	{
		super();
		this.setLayout(new GridBagLayout());
		selectors = new ArrayList<ToppingSelector>();
		
		addHeader(panelName, 0);

		pizzaChangingHandler = new PizzaChangingListener(super::raisePizzaChangingEvent);
			
		//Construct the toppings selectors for the panel
		for (int i = 0; i < toppings.length; i++)
		{
			addToppingSelector(toppings[i].getName(), toppings[i].isPremium(), i + 1);
		}
		
	}
	
	private void addHeader(String name, int panelRow)
	{
		JLabel lbl_title = new JLabel(name);
		lbl_title.setPreferredSize(HEADER_SIZE);
		add(lbl_title, HEADER_CONSTRAINTS);
		
		for(int i = 0; i < columns.length; i++)
		{
			JLabel headerLabel = new JLabel(columns[i]);
			headerLabel.setPreferredSize(LABEL_SIZE);
			add(headerLabel, new GridBagConstraints(i + 1, 0, 1, 1, .15, 0, GridBagConstraints.LINE_START, 
					GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		}
	}
	
	private void addToppingSelector(String name, boolean isPremium, int panelRow)
	{
		GridBagConstraints c = new GridBagConstraints(0, panelRow, 6, 1,  0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 30, 0);
		ToppingSelector s = new ToppingSelector(name, isPremium, panelRow == 1 ? true : false);
		s.addPizzaChangingListener(pizzaChangingHandler);
		selectors.add(s);
		add(s, c);
	}
	
	

	public void resetControls()
	{
		selectors.forEach(s -> s.resetControls());	
	}


}
