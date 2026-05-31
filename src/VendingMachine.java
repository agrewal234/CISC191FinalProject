import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
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
* Version: 2026-05-31
*
* Responsibilities of class:
* To manage the vending machine's inventory of products.
* To track the user's current balance.
* To allow users to insert money into the machine.
* To process product purchases and update inventory accordingly.
* To handle cases like insufficient funds or out-of-stock products.
*
* VendingMachine is-a class that represents a vending machine system
* 
*/
public class VendingMachine
{
	// A VendingMachine has-an ArrayList of inventory items
	private ArrayList<InventoryItem> inventory;
	
	// A VendingMachine has-a current user balance
	private double userBalance;
	
	/**
	 * Purpose: Initializes a VendingMachine object with an empty inventory and a starting user balance of 0.0
	 */
	public VendingMachine()
	{
		inventory = new ArrayList<>();
		userBalance = 0.0;
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
			userBalance += amount;
		}
	}
	
	/**
	 * Purpose: Returns the user's current balance
	 * @return the current user balance
	 */
	public double getUserBalance()
	{
		return userBalance;
	}
	
	/**
	 * Purpose: Displays all inventory items currently stored in the vending machine directly to the console.
	 * including the item's index number, product name, product price, and quantity.
	 */
	public void displayItems()
	{
		// Loop through each InventoryItem stored in the inventory ArrayList
		for (int i = 0; i < inventory.size(); i++)
		{
			// Retrieves the current inventory item
			InventoryItem item = inventory.get(i);
			
			// Displays the item's index, product name, price, and quantity
			System.out.printf( i + ". " + item.getProduct().getName() 
					+ " - $%.2f - Quantity: %d%n", item.getProduct().getPrice(), item.getQuantity());
		}
	}
	
	/**
	 * Purpose: Processes the purchase of the selected item by its index position in the ArrayList.
	 * Also checks whether the selection is valid, whether the item is in stock, and whether the user has sufficient funds before the purchase is completed.
	 * @param index the position of the selected item in the inventory ArrayList
	 * @throws OutOfStockException if the selected item is out of stock
	 * @throws InsufficientFundsException if the user's balance is too low
	 * @throws InvalidSelectionException if the selected index is invalid
	 */
	public void purchaseItem(int index) throws OutOfStockException, InsufficientFundsException, InvalidSelectionException
	{
		// Verifies that the selected index exists in the inventory
		if (index < 0 || index >= inventory.size())
		{
			throw new InvalidSelectionException("Invalid Selection.");
		}
		
		// Retrieves the selected inventory item from the ArrayList
		InventoryItem item = inventory.get(index);
		
		// Checks whether the selected item is out of stock
		if (item.getQuantity() == 0)
		{
			throw new OutOfStockException("Sorry, this item is out of stock.");
		}
		
		// Checks whether the user has enough money to purchase the item
		if (userBalance < item.getProduct().getPrice())
		{
			throw new InsufficientFundsException("Insufficient funds. Please add more money to balance.");
		}
		
		// Subtracts the item's price from the user's balance
		userBalance -= item.getProduct().getPrice();
		
		// Decreases the quantity of the purchased item by one.
		item.reduceQuantity();
		
		// Saves the completed purchase to the transaction history file
		writeTransactionToFile(item);
		
		// Displays a confirmation message in the console
		System.out.println("Purchased: " + item.getProduct().getName());
		
		
	}
	
	/**
	 * Purpose: Returns the inventory information as a String so it can be displayed in the GUI
	 * @return a formatted String containing all inventory items
	 */
	public String getInventoryDisplay()
	{
	    // Creates an empty String
		String display = "";

	    // Loop through each item in inventory
		for (int i = 0; i < inventory.size(); i++)
	    {
	        InventoryItem item = inventory.get(i);

	     // Adds the item's selection code, name, price, and quantity to the display String.
	        display += item.getSelectionCode()
	                + " - "
	                + item.getProduct().getName()
	                + " - $"
	                + String.format("%.2f", item.getProduct().getPrice())
	                + " - Quantity: "
	                + item.getQuantity()
	                + "\n";
	    }

	    return display;
	}
	
	/**
	 * Purpose: Returns an inventory item at the given index.
	 * This allows the GUI to access product information, such as the product name without directly accessing the inventory ArrayList.
	 * @param index the index of the item in the inventory ArrayList
	 * @return the InventoryItem at the given index
	 */
	public InventoryItem getItem(int index)
	{
		// Returns the InventoryItem stored at the given index
	    return inventory.get(index);
	}
	
	/**
	 * Purpose: Writes a completed purchase to a transaction history text file.
	 * This allows purchases to be saved.
	 * @param item the purchased inventory item
	 */
	private void writeTransactionToFile(InventoryItem item)
	{
	    try
	    {
	    	// Creates a FileWriter object and opens transactions.txt.
	        FileWriter writer = new FileWriter("transactions.txt", true);

	        // Writes the purchase information to the text file. Product name and price are recorded on a separate line.
	        writer.write("Purchased: "
	                + item.getProduct().getName()
	                + " - $"
	                + String.format("%.2f", item.getProduct().getPrice())
	                + "\n");

	        // Closes the file to ensure all data is saved properly.
	        writer.close();
	    }
	    catch (IOException e)
	    {
	    	// Displays an error message if the file cannot be written.
	        System.out.println("Transaction could not be saved.");
	    }
	}
	

}
