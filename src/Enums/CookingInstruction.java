package Enums;

public enum CookingInstruction
{
	NORMAL, LIGHT_BAKE, WELL_DONE;
	private static final String[] names = {"Normal Bake", "Light Bake", "Well Done"};
	
	public boolean isDefault()
	{
		return this.ordinal() == 0;
	}
	
	public String toString()
	{
		return names[this.ordinal()];
	}
}
