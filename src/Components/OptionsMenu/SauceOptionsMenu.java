package Components.OptionsMenu;
import Enums.PizzaOptions;
import Events.PizzaChangingEvent;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import Components.OptionsMenu.BaseClasses.OptionsMenu;

public class SauceOptionsMenu extends OptionsMenu
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5715268005524536953L;

	public SauceOptionsMenu(String title)
	{
		super(title, PizzaChangingEvent.SAUCE_CHANGING);
		
		super.btn_normal = new JRadioButton(PizzaOptions.NORMAL_SAUCE.toString(), true);
		super.btn_none = new JRadioButton(PizzaOptions.NO_SAUCE.toString());
		super.btn_light = new JRadioButton(PizzaOptions.LIGHT_SAUCE.toString());
		super.btn_extra = new JRadioButton(PizzaOptions.EXTRA_SAUCE.toString());
		
		super.btn_none.addActionListener(super.btnListener);
		super.btn_light.addActionListener(super.btnListener);
		super.btn_normal.addActionListener(super.btnListener);
		super.btn_extra.addActionListener(super.btnListener);
		
		super.bg.add(btn_normal);
		super.bg.add(btn_none);
		super.bg.add(btn_light);
		super.bg.add(btn_extra);
		
		add(btn_normal);
		add(btn_none);
		add(btn_light);
		add(btn_extra);
		
	}

	@Override
	protected void onRadioButtonClick(ActionEvent e)
	{
		Object source = e.getSource();
		this.raisePizzaChangingEvent(new PizzaChangingEvent(this, super.changingProperty, 
				source == btn_none ? PizzaChangingEvent.NO_SAUCE : 
				source == btn_light ? PizzaChangingEvent.LIGHT_SAUCE : 
				source == btn_normal ? PizzaChangingEvent.NORMAL_SAUCE : PizzaChangingEvent.EXTRA_SAUCE, e.getActionCommand()));
		
	}
	
	
}
