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
* <<Add more references here>>
*
* Version: 2026-05-05
*/

/**
 * Responsibilities of class:
 * To represent a drink product in the vending machine.
 * To inherit shared product information, such as name and price, from the Product class.
 *
 * A Drink is-a Product
 * 
 */
public class Drink extends Product
{

	/**
	 * Purpose: Initializes a Drink Product with a name and price
	 * @param name the name of the Drink
	 * @param price the price of the Drink
	 */
	public Drink(String name, double price)
	{
		super(name, price);
		
	}

}
