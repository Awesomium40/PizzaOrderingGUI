package Enums;

public enum ToppingsChoice
{
	NONE, FULL, FIRST_HALF, SECOND_HALF;
	private static final String[] names = {"None", "Full", "1st Half", "2nd Half"};
	
	public String toString()
	{
		return names[this.ordinal()];
	}
	
	public static String[] toStringArray()
	{
		return names;
	}
	
	public boolean equals(ToppingsChoice other)
	{
		return this.ordinal() == other.ordinal();
	}
}
