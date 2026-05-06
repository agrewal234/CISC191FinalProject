import java.util.ArrayList;
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
* GeeksforGeeks. (2025, July 12).
* Method Chaining in Java with Examples.
* https://www.geeksforgeeks.org/java/method-chaining-in-java-with-examples/
*
* Version: 2026-04-27
*
* Responsibilities of class:
* To manage the vending machine's inventory of products.
* To track the user's current balance.
* To allow users to insert money into the machine.
* To process product purchases and update inventory accordingly.
* To handle cases like insufficient funds or ou-of-stock products.
*
* VendingMachine is-a class that represents a vending machine system
* 
*/
public class VendingMachine
{
	// A VendingMachine has-an ArrayList of inventory items
	private ArrayList<InventoryItem> inventory;
	
	// A VendingMachine has-a current user balance
	private double balance;
	
	/**
	 * Purpose: Initializes a VendingMachine object with an empty inventory and a starting user balance of 0.0
	 */
	public VendingMachine()
	{
		inventory = new ArrayList<>();
		balance = 0.0;
	}
	
	/**
	 * Purpose: Adds a given InventoryItem object to the inventory ArrayList
	 * @param item the given item to add
	 */
	public void addItem(InventoryItem item)
	{
		inventory.add(item);
	}
	
	/**
	 * Purpose: Adds the given amount to the current user balance
	 * @param amount the given amount to add to balance
	 */
	public void insertMoney(double amount)
	{
		if (amount > 0)
		{
			balance += amount;
		}
	}
	
	/**
	 * Purpose: Returns the current user balance
	 * @return the current balance
	 */
	public double getBalance()
	{
		return balance;
	}
	
	/**
	 * Purpose: Displays all inventory items currently stored in the vending machine 
	 * including the item's index number, product name, product price, and quantity.
	 */
	public void displayItems()
	{
		for (int i = 0; i < inventory.size(); i++)
		{
			InventoryItem item = inventory.get(i);
			
			System.out.println( i + ". " + item.getProduct().getName() 
					+ " - $" + item.getProduct().getPrice() 
					+ " - Quantity: " + item.getQuantity());
		}
	}
	
	/**
	 * Purpose: Processes the purchase of the selected item by its index position in the ArrayList.
	 * Also checks whether the selection is valid, whether the item is in stock, and whether the user has sufficient funds before the purchase is completed.
	 * @param index the position of the selected item in the inventory ArrayList
	 */
	public void purchaseItem(int index)
	{
		if (index < 0 || index >= inventory.size())
		{
			System.out.println("Invalid Selection.");
			return;
		}
		
		InventoryItem item = inventory.get(index);
		
		if (item.getQuantity() == 0)
		{
			System.out.println("Sorry, this item is out of stock.");
			
		}
		else if (balance < item.getProduct().getPrice())
		{
			System.out.println("Insufficient funds. Please add more money to balance.");
		}
		else
		{
			balance -= item.getProduct().getPrice();
			item.reduceQuantity();
			System.out.println("Purchased: " + item.getProduct().getName());
		}
		
	}
}
