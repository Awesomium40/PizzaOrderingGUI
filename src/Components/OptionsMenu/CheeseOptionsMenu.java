package Components.OptionsMenu;
import java.awt.event.ActionEvent;

import javax.swing.*;
import Events.PizzaChangingEvent;
import Components.OptionsMenu.BaseClasses.OptionsMenu;
import Enums.PizzaOptions;

public class CheeseOptionsMenu extends OptionsMenu
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8522100954349803628L;
	
	//REGION PRIVATE MEMBERS
	
	public CheeseOptionsMenu(String title)
	{
		super(title, PizzaChangingEvent.CHEESE_CHANGING);
		super.btn_normal = new JRadioButton(PizzaOptions.NORMAL_CHEESE.toString(), true);
		super.btn_none = new JRadioButton(PizzaOptions.NO_CHEESE.toString());
		super.btn_light = new JRadioButton(PizzaOptions.LIGHT_CHEESE.toString());
		
		super.btn_none.addActionListener(super.btnListener);
		super.btn_light.addActionListener(super.btnListener);
		super.btn_normal.addActionListener(super.btnListener);
		
		super.bg.add(btn_normal);
		super.bg.add(btn_none);
		super.bg.add(btn_light);
		
		add(btn_normal);
		add(btn_none);
		add(btn_light);
		
	}

	@Override
	protected void onRadioButtonClick(ActionEvent e)
	{
		Object source = e.getSource();
		this.raisePizzaChangingEvent(new PizzaChangingEvent(this, super.changingProperty, 
				source == btn_none ? PizzaChangingEvent.NO_CHEESE : 
				source == btn_light ? PizzaChangingEvent.LIGHT_CHEESE : PizzaChangingEvent.NORMAL_CHEESE, e.getActionCommand()));
		
	}
	
}
