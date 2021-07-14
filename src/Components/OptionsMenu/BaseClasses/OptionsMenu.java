package Components.OptionsMenu.BaseClasses;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;
import javax.swing.*;
import EventListeners.Interfaces.IPizzaChangingListener;
import EventRaisers.NotifyPizzaChangingBase;
import EventRaisers.Interfaces.INotifyPizzaChanging;
import Enums.PizzaOptions;
import EventListeners.ButtonActionListener;
import Events.PizzaChangingEvent;

public abstract class OptionsMenu extends NotifyPizzaChangingBase
{
	
	//REGION PROTECTED MEMBERS
	protected JRadioButton btn_none;
	protected JRadioButton btn_light;
	protected JRadioButton btn_normal;
	protected JRadioButton btn_extra;
	protected ButtonGroup bg;
	protected PizzaOptions instruction;
	protected ArrayList<IPizzaChangingListener> subscribers;
	protected ButtonActionListener btnListener;
	protected byte changingProperty;
	protected byte changeRequested;
	/**
	 * 
	 */
	private static final long serialVersionUID = 677877659308596494L;
	
	//REGION CONSTRUCTORS
	/**
	 * Creates a new instance of the object
	 * @param title the title of the panel for the current instance
	 * @param property The property of a pizza whose options the current instance selects
	 */
	public OptionsMenu(String title, byte property)
	{
		//Set the layout and appearance
		super(new FlowLayout(FlowLayout.LEFT));		
		setBorder(BorderFactory.createTitledBorder(title));
		bg = new ButtonGroup();
		subscribers = new ArrayList<IPizzaChangingListener>();
		btnListener = new ButtonActionListener(this::onRadioButtonClick);
		changingProperty = property;
	}
	
	public void resetControls()
	{
		btn_normal.doClick();
	}
	
	//REGION METHODS
	
	/**
	 * handles the events raised when radio buttons within the current instance are clicked
	 * @param e ActionEvent
	 */
	protected abstract void onRadioButtonClick(ActionEvent e);

}
