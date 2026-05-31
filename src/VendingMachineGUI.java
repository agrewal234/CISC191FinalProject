import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
* Lead Author(s):
* @author anisagrewal; student ID
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
* GeeksforGeeks. (2025, July 11).
* Java AWT GridLayout Class.
* https://www.geeksforgeeks.org/java/java-awt-gridlayout-class/
* 
* Stack Overflow. (2014, April 12).
* What is the difference between ActionListener and ActionEvent for a button?
* Retrieved from https://stackoverflow.com/questions/23033439/what-is-the-difference-between-actionlistener-and-actionevent-for-a-button
*
* Version: 2026-05-24
*/

/**
 * Responsibilities of class:
 *
 * Creates the graphical user interface for the vending machine simulator
 * Allows user to view inventory, insert money, select an item, purchase an item, and cancel a transaction using buttons and display labels
 * 
 * A VendingMachineGUI is-a JFrame
 * 
 */
public class VendingMachineGUI extends JFrame
{
	// A VendingMachineGUI has-a VendingMachine object which stores the vending machine logic
	private VendingMachine vendingMachine;

	// A VendingMachineGUI has-a text area to display the current inventory
    private JTextArea inventoryArea;
    
    // VendingMachineGUI has-a balance label to display the user's current balance
    private JLabel balanceLabel;
    
    // VendingMachineGUI has-a message label to display messages to the user
    private JLabel messageLabel;

    // Stores the index of the item selected by the user
    // A value of -1 means that no item is currently selected
    private int selectedIndex = -1;

    /**
     * Purpose: Constructs the vending machine GUI, adds sample inventory, creates the buttons, labels, panels, and connects button clicks to methods.
     */
    public VendingMachineGUI()
    {
    	// Creates the VendingMachine object that the GUI will interact with
        vendingMachine = new VendingMachine();
        
        // Adds all the sample products to the vending machine inventory
        vendingMachine.addItem(new InventoryItem(new Snack("Chips", 1.50), 8, "A1"));
        vendingMachine.addItem(new InventoryItem(new Drink("Soda", 2.00), 4, "A2"));
        vendingMachine.addItem(new InventoryItem(new Snack("Chocolate", 1.25), 5, "A3"));

        vendingMachine.addItem(new InventoryItem(new Drink("Water", 1.00), 9, "B1"));
        vendingMachine.addItem(new InventoryItem(new Drink("Coffee", 2.50), 6, "B2"));
        vendingMachine.addItem(new InventoryItem(new Snack("Cookies", 1.75), 7, "B3"));

        vendingMachine.addItem(new InventoryItem(new Snack("Pretzels", 1.25), 10, "C1"));
        vendingMachine.addItem(new InventoryItem(new Drink("Energy Drink", 3.00), 3, "C2"));
        vendingMachine.addItem(new InventoryItem(new Snack("Granola Bar", 1.50), 8, "C3"));

        // Sets the title shown at the top of the window
        setTitle("Vending Machine Simulator");
        
        // Allows the program to close when the user clicks the X button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Uses BorderLayout to organize the GUI into north, center, and south sections
        setLayout(new BorderLayout());

        // Creates a text area to display the inventory
        inventoryArea = new JTextArea(10, 35);
        
        // Prevents the user from typing directly into the inventory display
        inventoryArea.setEditable(false);
        
        // Adds the inventory display to the center of the window with scrolling
        add(new JScrollPane(inventoryArea), BorderLayout.CENTER);

        // Creates a top panel with two rows for the balance and message labels
        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        
        // Creates a label to show the current user balance
        balanceLabel = new JLabel("Balance: $0.00");
        
        // Creates a label to show instructions and feedback messages
        messageLabel = new JLabel("Welcome! Insert money and select an item.");
        
        // Adds the labels to the top panel
        topPanel.add(balanceLabel);
        topPanel.add(messageLabel);
        
        // Adds the top panel to the north section of the window
        add(topPanel, BorderLayout.NORTH);

        // Creates a button panel arranged in a grid
        JPanel buttonPanel = new JPanel(new GridLayout(3, 5, 5, 5));
        
        // Creates selection buttons for each item
        JButton item0Button = new JButton("Select A1");
        JButton item1Button = new JButton("Select A2");
        JButton item2Button = new JButton("Select A3");
        JButton item3Button = new JButton("Select B1");
        JButton item4Button = new JButton("Select B2");
        JButton item5Button = new JButton("Select B3");
        JButton item6Button = new JButton("Select C1");
        JButton item7Button = new JButton("Select C2");
        JButton item8Button = new JButton("Select C3");

        // Registers an ActionListener for the A1 button
        // When clicked, item A1 becomes the currently selected item
        item0Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                selectItem(0);
            }
        });
        
        // Registers an ActionListener for the A2 button
        // When clicked, item A2 becomes the currently selected item
        item1Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                selectItem(1);
            }
        });

        // Registers an ActionListener for the A3 button
        // When clicked, item A3 becomes the currently selected item
        item2Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                selectItem(2);
            }
        });

        // Registers an ActionListener for the B1 button.
        // When clicked, item B1 becomes the currently selected item.
        item3Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                selectItem(3);
            }
        });
        
        // Registers an ActionListener for the B2 button.
        // When clicked, item B2 becomes the currently selected item.
        item4Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                selectItem(4);
            }
        });

        // Registers an ActionListener for the B3 button.
        // When clicked, item B3 becomes the currently selected item.
        item5Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                selectItem(5);
            }
        });

        // Registers an ActionListener for the C1 button.
        // When clicked, item C1 becomes the currently selected item.
        item6Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                selectItem(6);
            }
        });

        // Registers an ActionListener for the C2 button.
        // When clicked, item C2 becomes the currently selected item.
        item7Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                selectItem(7);
            }
        });

        // Registers an ActionListener for the C3 button.
        // When clicked, item C3 becomes the currently selected item.
        item8Button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                selectItem(8);
            }
        });

        // Creates buttons for adding money and completing/canceling transactions
        JButton addOneButton = new JButton("Add $1.00");
        JButton addFiveButton = new JButton("Add $5.00");
        JButton purchaseButton = new JButton("Purchase");
        JButton cancelButton = new JButton("Cancel");

        // Registers an ActionListener with the "Add $1.00" button
        // When the button is clicked, actionPerformed() executes and adds $1.00 to the user's balance.
        addOneButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                insertMoney(1.00);
            }
        });

        // Registers an ActionListener with the Add $5.00 button
        // When clicked, the user's balance increases by $5.00
        addFiveButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                insertMoney(5.00);
            }
        });

        // Registers an ActionListener with the Purchase button
        // When clicked, the GUI attempts to purchase the currently selected item and handles any exceptions that may occur
        purchaseButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                purchaseSelectedItem();
            }
        });

        // Registers an ActionListener with the Cancel button
        // When clicked, the current transaction is cancelled and the selected item is cleared
        cancelButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                cancelTransaction();
            }
        });

        // Adds all buttons to the button panel
        buttonPanel.add(item0Button);
        buttonPanel.add(item1Button);
        buttonPanel.add(item2Button);
        buttonPanel.add(item3Button);
        buttonPanel.add(item4Button);
        buttonPanel.add(item5Button);
        buttonPanel.add(item6Button);
        buttonPanel.add(item7Button);
        buttonPanel.add(item8Button);
        buttonPanel.add(addOneButton);
        buttonPanel.add(addFiveButton);
        buttonPanel.add(purchaseButton);
        buttonPanel.add(cancelButton);

        // Adds the button panel to the bottom of the window
        add(buttonPanel, BorderLayout.SOUTH);

        // Updates the inventory and balance display before the window appears
        updateDisplay();

        // Sizes the window so all components fit properly
        pack();
        
        // Centers the window on the screen
        setLocationRelativeTo(null);
        
        // Makes the window visible to the user
        setVisible(true);
    }

    /**
     * Purpose: Stores the selected inventory index when the user clicks an item button.
     * Also displays the selected product name to the user.
     * @param index the inventory index of the selected item
     */
    private void selectItem(int index)
    {
    	// Stores the selected inventory index
        selectedIndex = index;

        // Retrieves the name of the selected product
        String itemName = vendingMachine.getItem(index).getProduct().getName();

        // Displays the selected product name to the user
        messageLabel.setText("Selected: " + itemName + ". Click Purchase to buy.");
    }

    /**
     * Purpose: Adds money to the user's balance and refreshes the GUI display.
     * @param amount the amount of money being inserted
     */
    private void insertMoney(double amount)
    {
    	// Adds the specified amount to the user's balance
        vendingMachine.insertMoney(amount);
        
        // Displays a confirmation message showing the amount added
        messageLabel.setText("Added $" + String.format("%.2f", amount) + ".");
        
        // Refreshes the inventory and balance display
        updateDisplay();
    }

    /**
     * Purpose: Attempts to purchase the selected item and displays exception messages
     * if the selection is invalid, out of stock, or the user has insufficient funds.
     */
    private void purchaseSelectedItem()
    {
        try
        {
        	// Checks whether the user has selected an item
            if (selectedIndex == -1)
            {
                throw new InvalidSelectionException("Please select an item first.");
            }

            // Attempts to purchase the selected item
            vendingMachine.purchaseItem(selectedIndex);
            
            // Displays a success message when the purchase is completed
            messageLabel.setText("Purchase successful!");
            
            // Clears the selected item after the purchase
            selectedIndex = -1;
        }
        catch (InvalidSelectionException | OutOfStockException | InsufficientFundsException ex)
        {
        	// Displays the exception message to the user
            messageLabel.setText(ex.getMessage());
        }

        // Refreshes the inventory and balance display
        updateDisplay();
    }

    /**
     * Purpose: Clears the selected item and cancels the current transaction.
     */
    private void cancelTransaction()
    {
    	// Removes the current item selection (changes it back to -1)
        selectedIndex = -1;
        
        // Displays a cancellation message to the user
        messageLabel.setText("Transaction cancelled.");
        
        // Refreshes the inventory and balance display
        updateDisplay();
    }

    /**
     * Purpose: Refreshes the inventory display and balance label shown in the GUI.
     */
    private void updateDisplay()
    {
    	// Updates the inventory text area with the current inventory information
        inventoryArea.setText(vendingMachine.getInventoryDisplay());
        
        // Updates the balance label with the user's current balance
        balanceLabel.setText("Balance: $" + String.format("%.2f", vendingMachine.getUserBalance()));
    }

    /**
     * Purpose: Starts the vending machine GUI application
     */
    public static void main(String[] args)
    {
    	// Creates and displays a new VendingMachineGUI window
        new VendingMachineGUI();
    }
}
