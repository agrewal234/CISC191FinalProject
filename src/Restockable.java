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
 * Responsibilities of Interface:
 * To define behavior for classes that can have their quantity increased.
 * To require implementing classes to provide a restock method.
 *
 * Restockable is-an interface.
 * 
 */

/**
 * Purpose: Defines the behavior for increasing the quantity of a restockable item.
 * @param amount the amount to add to the current quantity
 */
public interface Restockable
{
	
	void restock(int amount);
}
