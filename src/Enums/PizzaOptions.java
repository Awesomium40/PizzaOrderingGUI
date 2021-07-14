package Enums;

public enum PizzaOptions
{

	NORMAL_CHEESE, NO_CHEESE, LIGHT_CHEESE, NORMAL_BAKE, LIGHT_BAKE, EXTRA_BAKE, 
	NORMAL_SAUCE, NO_SAUCE, LIGHT_SAUCE, EXTRA_SAUCE;
	private String[] names = new String[] {"Normal Cheese", "No Cheese", "Light Cheese", "Normal Bake", "Light Bake", "Well Done Bake", 
			"Normal Sauce", "No Sauce", "Light Sauce", "Extra Sauce"};
	
	public String toString()
	{
		return names[this.ordinal()];
	}
}
