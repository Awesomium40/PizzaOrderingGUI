package DataModel;

public class ToppingStarter
{
	private String name;
	private boolean isPremium;
	
	public ToppingStarter(String name, boolean isPremium)
	{
		this.name = name;
		this.isPremium = isPremium;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public boolean isPremium()
	{
		return this.isPremium;
	}
}
