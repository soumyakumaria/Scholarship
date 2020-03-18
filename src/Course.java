/**
 * This is the initial Course class created for iteration 2 
 * @author Tiffany
 *
 */
public class Course {
	private String name; 
	private String number; 
	private String gradeLetter;
	
	/**
	 * Get the name of the course. 
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Set the name of the course. 
	 * @param name the name to set
	 */
	private void setName(String name) {
		this.name = name;
	} 
	
	/**
	 * Get the course number. 
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * Set the course number. 
	 * @param number the number to set
	 */
	private void setNumber(String number) {
		this.number = number;
	}

}
