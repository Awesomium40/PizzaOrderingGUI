package Enums;

public enum CheeseInstruction
{
	NORMAL, NO_CHEESE, LIGHT_CHEESE;
	private static final String[] names = {"Normal", "None", "Light"};
	
	public boolean isDefault()
	{
		return this.ordinal() == 0;
	}
	
	public String toString()
	{
		return names[this.ordinal()];
	}
}
