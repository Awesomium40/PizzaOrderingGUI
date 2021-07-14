/**
 * PizzaTopping.java
 * Represents a pizza topping/ingredient at Quickman's Pizza
 */
package DataModel;

import Enums.ToppingsChoice;

public class PizzaTopping
{
	private String name;
	private ToppingsChoice choice;
	private boolean isDoubleToppings;
	private boolean isPremiumTopping;
	private static final double REGULAR_PRICE = 1.5;
	private static final double PREMIUM_PRICE = 2.0;
	private static final String formatString = "[%1$sTopping: %2$s %3$sx %4$s]";
	
	/**
	 * Creates a new PizzaTopping
	 * @param name The name of the topping
	 * @param choice The choice of the topping (None, half, half, full)
	 * @param isDouble Whether the topping is a doubled
	 * @param isPremium Whether the topping is a premium topping
	 */
	public PizzaTopping(String name, ToppingsChoice choice, boolean isDouble, boolean isPremium)
	{
		this.name = name;
		this.choice = choice;
		this.isDoubleToppings = isDouble;
		this.isPremiumTopping = isPremium;
	}
	
	/***
	 * Copy constructor for PizzaToppings
	 * @param t The PizzaTopping object to copy
	 */
	public PizzaTopping(PizzaTopping t)
	{
		this.name = t.name;
		this.choice = t.choice;
		this.isDoubleToppings = t.isDoubleToppings;
		this.isPremiumTopping = t.isPremiumTopping;
	}
	
	public String getToppingName()
	{
		return this.name;
	}
	
	public ToppingsChoice getToppingChoice()
	{
		return this.choice;
	}
	
	public boolean isDoubleToppings()
	{
		return this.isDoubleToppings;
	}
	
	public double getPrice()
	{
		return ((isPremiumTopping ? PizzaTopping.PREMIUM_PRICE : PizzaTopping.REGULAR_PRICE) * (this.isDoubleToppings ? 2 : 1)) / 
				(this.choice == ToppingsChoice.FIRST_HALF || this.choice == ToppingsChoice.SECOND_HALF ? 2 : 1 );
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public boolean equals(PizzaTopping other)
	{
		return this.name.equals(other.name) && this.isDoubleToppings == other.isDoubleToppings &&
				this.choice.equals(other.choice) && this.isPremiumTopping == other.isPremiumTopping;
				
	}
	
	public String toString()
	{
		return String.format(formatString, this.isPremiumTopping ? "Premium " : "", 
										   this.name, 
										   this.isDoubleToppings ? 2 : 1, 
										   this.choice);
	}
}
