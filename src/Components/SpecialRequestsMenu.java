package Components;
import java.awt.*;
import javax.swing.*;

import Enums.CheeseInstruction;
import Enums.CookingInstruction;
import Enums.SauceInstruction;

public class SpecialRequestsMenu extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8671264588036097772L;
	//REGION COMPONENTS
	JLabel label;
	ButtonGroup cheeseButtons;
	ButtonGroup sauceButtons;
	ButtonGroup bakeButtons;
	
	JRadioButton btn_noCheese;
	JRadioButton btn_normalCheese;
	JRadioButton btn_lightCheese;
	
	JRadioButton btn_noSauce;
	JRadioButton btn_normalSauce;
	JRadioButton btn_lightSauce;
	JRadioButton btn_extraSauce;
	
	JRadioButton btn_lightBake;
	JRadioButton btn_normalBake;
	JRadioButton btn_wellDoneBake;
	
	public SpecialRequestsMenu()
	{
		super(new GridLayout(4, 1));

		JPanel pnl;
		
		//Construct the components
		label = new JLabel("Special Instructions");
		
		cheeseButtons = new ButtonGroup();
		btn_noCheese = new JRadioButton(CheeseInstruction.NO_CHEESE.toString());
		btn_normalCheese = new JRadioButton(CheeseInstruction.NORMAL.toString(), true);
		btn_lightCheese = new JRadioButton(CheeseInstruction.LIGHT_CHEESE.toString());
		
		cheeseButtons.add(btn_normalCheese);
		cheeseButtons.add(btn_noCheese);
		cheeseButtons.add(btn_lightCheese);
		
		sauceButtons = new ButtonGroup();
		btn_noSauce = new JRadioButton(SauceInstruction.NO_SAUCE.toString());
		btn_normalSauce = new JRadioButton(SauceInstruction.NORMAL.toString(), true);
		btn_lightSauce = new JRadioButton(SauceInstruction.LIGHT_SAUCE.toString());
		btn_extraSauce = new JRadioButton(SauceInstruction.EXTRA_SAUCE.toString());
		
		sauceButtons.add(btn_normalSauce);
		sauceButtons.add(btn_noSauce);
		sauceButtons.add(btn_lightSauce);
		sauceButtons.add(btn_extraSauce);
		
		bakeButtons = new ButtonGroup();
		btn_lightBake = new JRadioButton(CookingInstruction.LIGHT_BAKE.toString());
		btn_normalBake = new JRadioButton(CookingInstruction.NORMAL.toString(), true);
		btn_wellDoneBake = new JRadioButton(CookingInstruction.WELL_DONE.toString());
		
		bakeButtons.add(btn_normalBake);
		bakeButtons.add(btn_lightBake);
		bakeButtons.add(btn_wellDoneBake);
		
		//Add the components to the layout
		add(label);
		
		//start with the cheese option
		pnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnl.setBorder(BorderFactory.createTitledBorder("Cheese"));
		pnl.add(btn_normalCheese);
		pnl.add(btn_noCheese);
		pnl.add(btn_lightCheese);
		add(pnl);
		
		//then sauce
		pnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnl.setBorder(BorderFactory.createTitledBorder("Sauce"));
		pnl.add(btn_normalSauce);
		pnl.add(btn_noSauce);
		pnl.add(btn_lightSauce);
		pnl.add(btn_extraSauce);
		add(pnl);
		
		//then bake
		pnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnl.setBorder(BorderFactory.createTitledBorder("Bake"));
		pnl.add(btn_normalBake);
		pnl.add(btn_lightBake);
		pnl.add(btn_wellDoneBake);
		add(pnl);
	}
	
	
}
