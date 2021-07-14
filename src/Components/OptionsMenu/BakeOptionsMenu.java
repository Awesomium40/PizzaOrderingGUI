package Components.OptionsMenu;
import java.awt.event.ActionEvent;
import javax.swing.*;
import Components.OptionsMenu.BaseClasses.OptionsMenu;
import Enums.PizzaOptions;
import Events.PizzaChangingEvent;

public class BakeOptionsMenu extends OptionsMenu
{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7470788374614112444L;

	public BakeOptionsMenu(String title)
	{
		super(title, PizzaChangingEvent.BAKE_CHANGING);
		
		super.btn_normal = new JRadioButton(PizzaOptions.NORMAL_BAKE.toString(), true);
		super.btn_light = new JRadioButton(PizzaOptions.LIGHT_BAKE.toString());
		super.btn_extra = new JRadioButton(PizzaOptions.EXTRA_BAKE.toString());
		
		super.btn_normal.addActionListener(super.btnListener);
		super.btn_light.addActionListener(super.btnListener);
		super.btn_extra.addActionListener(super.btnListener);
		
		super.bg.add(btn_normal);
		super.bg.add(btn_light);
		super.bg.add(btn_extra);
		
		add(btn_normal);
		add(btn_light);
		add(btn_extra);
		
	}


	@Override
	protected void onRadioButtonClick(ActionEvent e)
	{
		Object source = e.getSource();
		raisePizzaChangingEvent(new PizzaChangingEvent(this, super.changingProperty,
				source == super.btn_normal ? PizzaChangingEvent.NORMAL_BAKE : 
				source == super.btn_light ? PizzaChangingEvent.LIGHT_BAKE : PizzaChangingEvent.WELL_DONE_BAKE, e.getActionCommand()));
	}


}
