package Events;
import java.awt.event.ActionEvent;
import Enums.ButtonInstructionType;
import Enums.PizzaOptions;

/**
public class SelectionChangedEvent extends ActionEvent
{

	private static final long serialVersionUID = 2981653705370447883L;
	private PizzaOptions selection;
	private ButtonInstructionType instruction;
	
	public SelectionChangedEvent(Object source, PizzaOptions selection, ButtonInstructionType instruction)
	{
		super(source, ActionEvent.ACTION_PERFORMED, selection.toString());
		this.selection = selection;
		this.instruction = instruction;
	}
	
	public PizzaOptions getSelection()
	{
		return this.selection;
	}
	
	public ButtonInstructionType getInstruction()
	{
		return this.instruction;
	}
}
*/