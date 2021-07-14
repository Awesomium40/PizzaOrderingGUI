package Components;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import Enums.PizzaSizes;
import EventListeners.ButtonActionListener;
import EventListeners.Interfaces.IPizzaChangingListener;
import EventRaisers.NotifyPizzaChangingBase;
import Events.PizzaChangingEvent;

public class SizeMenu extends NotifyPizzaChangingBase
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 894152224423329521L;
	//REGION COMPONENTS
	private JRadioButton btn_small;
	private JRadioButton btn_large;
	private JRadioButton btn_xLarge;
	private ButtonGroup bg;
	private ButtonActionListener listener;
	private JLabel lbl_title;
	
	private static final String formatString = "%1$s - %2$s + $1.50/Regular Topping + $2.00/Premium Topping";
	
	/***
	 * Creates a new instance of the SizeMenu object
	 */
	public SizeMenu()
	{
		super(new GridLayout(4, 1));
		setBorder(new EmptyBorder(5, 0, 0, 0));
		
		NumberFormat dollar = NumberFormat.getCurrencyInstance(new Locale("en", "US"));
		subscribers = new ArrayList<IPizzaChangingListener>();
		listener = new ButtonActionListener(this::onButtonClick);
		
		//Construct the child components
		btn_small = new JRadioButton(String.format(formatString, PizzaSizes.SMALL.toString(), dollar.format(PizzaSizes.SMALL.getBasePrice())), true);
		btn_large = new JRadioButton(String.format(formatString, PizzaSizes.LARGE.toString(), dollar.format(PizzaSizes.LARGE.getBasePrice())));
		btn_xLarge = new JRadioButton(String.format(formatString, PizzaSizes.XLARGE.toString(), dollar.format(PizzaSizes.XLARGE.getBasePrice())));
		lbl_title = new JLabel("Size");
		bg = new ButtonGroup();
		
		bg.add(btn_small);
		bg.add(btn_large);
		bg.add(btn_xLarge);
		
		btn_small.addActionListener(listener);
		btn_large.addActionListener(listener);
		btn_xLarge.addActionListener(listener);
		
		//Add the components to the panel
		add(lbl_title);
		add(btn_small);
		add(btn_large);
		add(btn_xLarge);
		
	}
	
	private void onButtonClick(ActionEvent e)
	{
		Object source = e.getSource();
		raisePizzaChangingEvent(new PizzaChangingEvent(this, PizzaChangingEvent.SIZE_CHANGING, 
				source == btn_small ? PizzaChangingEvent.SMALL_PIZZA : 
				source == btn_large ? PizzaChangingEvent.LARGE :
				PizzaChangingEvent.XLARGE, e.getActionCommand()));
	}
	
	public void resetControls()
	{
		btn_small.doClick();
	}
	
}
