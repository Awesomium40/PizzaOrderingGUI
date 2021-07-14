package Enums;

public enum SauceInstruction
{
	NORMAL, NO_SAUCE, LIGHT_SAUCE, EXTRA_SAUCE;
	private static final String[] names = {"Normal", "None", "Light", "Extra"};
	
	public boolean isDefault()
	{
		return this.ordinal() == 0;
	}
	
	public String toString()
	{
		return names[this.ordinal()];
	}
}
