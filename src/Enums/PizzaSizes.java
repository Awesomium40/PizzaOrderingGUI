package Enums;

/**
 * an enum for the various sizes of pizza
 * @author Justin
 *
 */
public enum PizzaSizes
{
	SMALL, LARGE, XLARGE;
	private static final double[] basePrices = {7.99, 11.99, 13.99};
	private static final String[] names = {"Small", "Large", "Extra Large"};
	
	public boolean isDefault()
	{
		return this.ordinal() == 0;
	}
	
	public double getBasePrice()
	{
		return basePrices[this.ordinal()];
	}
	
	public String toString()
	{
		return names[this.ordinal()];
	}
}
