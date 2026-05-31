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
* GeeksforGeeks. (2025).
* Multi-Catch in Java.
* https://www.geeksforgeeks.org/java/multicatch-in-java/
*
* GeeksforGeeks. (2025).
* Formatted Output in Java.
* https://www.geeksforgeeks.org/java/formatted-output-in-java/
*
* GeeksforGeeks. (2025).
* Format Specifiers in Java.
* https://www.geeksforgeeks.org/java/format-specifiers-in-java/
*
* GeeksforGeeks. (2025).
* Exceptions in Java.
* https://www.geeksforgeeks.org/java/exceptions-in-java/
*
* Version: 2026-05-08
*/

/**
 * Responsibilities of class:
 *
 * To test the functionality of the VendingMachine class
 * 
 * A VendingMachineTester is-a class used for testing
 * 
 */
public class VendingMachineTester
{

	/**
	 * Purpose: Creates a VendingMachine object and tests invalid selection, out-of-stock item, insufficient funds, and successful purchase scenarios
	 * @param args command line arguments
	 */
	public static void main(String[] args)
	{
		// Creates a VendingMachine object for testing
		VendingMachine machine = new VendingMachine();
		
		// Creates Product objects to be added to inventory
		Product chips = new Product("Chips", 1.50);
		Product soda = new Product("Soda", 2.00);
		Product chocolateBar = new Product("Chocolate Bar", 1.75);
		
		// Creates InventoryItem objects with quantities and selection codes
		InventoryItem chipsItem = new InventoryItem(chips, 3, "A1");
		InventoryItem sodaItem = new InventoryItem(soda, 0, "A2");
		InventoryItem chocolateBarItem = new InventoryItem(chocolateBar, 5, "A3");
		
		// Adds the inventory items to the vending machine
		machine.addItem(chipsItem);
		machine.addItem(sodaItem);
		machine.addItem(chocolateBarItem);
		
		// Displays the initial inventory
		System.out.println("Available Items: ");
		machine.displayItems();
		
		 // Tests handling of an invalid item selection.
		System.out.println("\nTest 1: Invalid selection");
		try
		{
			// Attempts to purchase an item using an invalid index
			machine.purchaseItem(10);
		}
		catch (InvalidSelectionException | OutOfStockException | InsufficientFundsException e)
		{
			// Displays the exception message if an error occurs
			System.out.println(e.getMessage());
		}
		
		
		// Tests purchasing an item that is out of stock
		System.out.println("\nTest 2: Out of stock item");
		try
		{	
			machine.purchaseItem(1);
		}
		catch (InvalidSelectionException | OutOfStockException | InsufficientFundsException e)
		{
			System.out.println(e.getMessage());
		}
		
		// Tests purchasing an item without sufficient funds
		System.out.println("\nTest 3: Insufficient funds");
		try
		{
			machine.purchaseItem(0);
		}
		catch (InvalidSelectionException | OutOfStockException | InsufficientFundsException e)
		{
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("\nTest 4: Successful transaction");
		
		// Adds money to the user's balance before testing a successful purchase.
		machine.insertMoney(5.00);
		
		try
		{
			// Attempts to purchase an item with sufficient funds
			machine.purchaseItem(0);
		}
		catch (InvalidSelectionException | OutOfStockException | InsufficientFundsException e)
		{
			System.out.println(e.getMessage());
		}
		
		// Displays the remaining user balance after the purchase
		System.out.printf("\nRemaining Balance: $%.2f%n", machine.getUserBalance());
		
		// Tests the restocking functionality
		System.out.println("\nTest 5: Restocking Chips");

		// Increases the quantity of Chips by 2.
		chipsItem.restock(2);

		// Displays the inventory after restocking.
		machine.displayItems();
		
		System.out.println("\nUpdated Inventory: ");
		
		machine.displayItems();
	}

}
