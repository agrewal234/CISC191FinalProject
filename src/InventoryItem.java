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
* Version: 2026-04-27
*
* Responsibilities of class:
* To represent a product and its quantity within the vending machine.
* To keep track of how many units of a specific product are available.
* To increase the quantity when inventory is re-stocked.
* To decrease the quantity when a product is purchased.
* 
*
* InventoryItem is-a class that represents a product stored in inventory.
* InventoryItem is Restockable
* 
*/
public class InventoryItem implements Restockable
{
	// An Inventory item has-a specific Product it is associated with
	private Product product;
	
	// An InventoryItem has-a quantity
	private int quantity;
	
	/**
	 * Purpose: Initializes an InventoryItem object with a specific product and quantity.
	 * @param product the product associated with this inventory item
	 * @param quantity the initial quantity of the product
	 */
	public InventoryItem(Product product, int quantity)
	{
		this.product = product;
		this.quantity = quantity;
	}
	
	/**
	 * Purpose: Returns the product associated with this inventory item
	 * @return the product stored in this inventory item
	 */
	public Product getProduct()
	{
		return product;
	}
	
	/**
	 * Purpose: Returns the current quantity of the product
	 * @return the quantity available
	 */
	public int getQuantity()
	{
		return quantity;
	}
	
	/**
	 * Purpose: Reduces the quantity of the InventoryItem if the quantity is not already 0.
	 * 
	 */
	public void reduceQuantity()
	{
		if (quantity > 0)
		{
			quantity--;
		}
	}
	
	/**
	 * Purpose: Increases the quantity of the InventoryItem by the given amount
	 * @param amount the amount to increase
	 */
	@Override
	public void restock(int amount)
	{
		if (amount > 0) 
		{
			quantity += amount;
		}
	}
	
	/**
	 * Purpose: Returns a String representation of the InventoryItem object
	 * @return a String containing the product information and current available quantity
	 */
	@Override
	public String toString()
	{
		return product.toString() + " Quantity: " + quantity;
	}
}
