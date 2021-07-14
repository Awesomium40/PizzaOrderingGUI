/**
 * Order.java
 * Class that represents an order at Quickman's Pizza
 * Holds a collection of Pizza objects
 */
package DataModel;

import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Order
{
	private ArrayList<Pizza> pizzas;
	
	public Order()
	{
		pizzas = new ArrayList<Pizza>();
	}
	
	public void addPizza(Pizza p)
	{
		pizzas.add(p);
	}
	
	public String toString()
	{
		StringJoiner j = new StringJoiner("\n");
		
		pizzas.forEach(p -> j.add(p.toString()));
		
		return j.toString();
	}
	
	public int getQuantity()
	{
		return pizzas.size();
	}
}
