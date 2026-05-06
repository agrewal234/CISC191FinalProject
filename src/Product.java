/**
* Lead Author(s):
* @author Anisa Grewal
* @author Full name; student ID
* <<Add additional lead authors here>>
*
* Other Contributors:
* Full name; student ID or contact information if not in class
* <<Add additional contributors (mentors, tutors, friends) here, with contact information>>
*
* References:
* Morelli, R., & Walde, R. (2016).
* Java, Java, Java: Object-Oriented Problem Solving
* https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
*
* <<Add more references here>>
*
* Version: 2026-04-24
*
* Responsibilities of class:
* To represent a product that can be sold in a vending machine.
* To store the product's name and price.
*
*
* Product is-a class that represents an item available for purchase.
*
*/
public class Product
{
	// A Product has-a name
	private String name;
	
	// A Product has-a price
	private double price;
	
	/**
	 * Purpose: Initializes a Product object with a name and price when created
	 * @param name the product's name
	 * @param price the product's price
	 */
	public Product(String name, double price)
	{
		this.name = name;
		
		if (price < 0)
		{
			this.price = 0;
		}
		else
		{
			this.price = price;
		}
		
	}
	
	/**
	 * Purpose: Returns the name of the Product
	 * @return the product name
	 */
	public String getName()
	{
		return name;
	}
	
	/**

	 * Purpose: Returns the price of the Product
	 * @return the product price
	 */
	public double getPrice()
	{
		return price;
	}
	
	/**
	 * Purpose: To return a String representation of the Product object
	 * @return a String containing the Product's name and price
	 */
	@Override
	public String toString()
	{
		return name + " ($" + price + ")";
	}
}
