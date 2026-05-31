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
* GeeksforGeeks. (2025, August 8).
* SerialVersionUID in Java.
* Retrieved from https://www.geeksforgeeks.org/java/serialversionuid-in-java/
*
* Version: 2026-05-26
*/

/**
 * Responsibilities of class:
 * To represent an exception that occurs when a user does not have enough funds in their balance to purchase a selected inventory item.
 *
 * InsufficientFundsException is-an Exception
 *
 */
public class InsufficientFundsException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public InsufficientFundsException(String message)
	{
		super(message);
	}
}
