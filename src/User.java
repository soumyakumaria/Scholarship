/**
 * This is the initial User class created for iteration 2 
 * @author Tiffany 
 *
 */
public class User { 
	private String schoolEmail;
	private String schoolID; 
	private String schoolName; 
	private String firstName; 
	private String lastName; 
	private String password; 
	private String dateOfBirth; 
	
	/**
	 * Constructor
	 */
	public User() {
		
	}
	
	/**
	 * Get the user's school email. 
	 * @return the schoolEmail 
	 */
	public String getSchoolEmail() {
		return this.schoolEmail; 
	}
	
	/**
	 * Set the user's school email. 
	 * @param schoolEmail
	 */
	private void setSchoolEmail(String schoolEmail) {
		this.schoolEmail = schoolEmail; 
	}

	/**
	 * Get the user's school ID. 
	 * @return the schoolID
	 */
	public String getSchoolID() {
		return this.schoolID; 
	}
	
	/**
	 * Set the user's school ID
	 * @param schoolID
	 */
	private void setSchoolID(String schoolID) {
		this.schoolID = schoolID; 
	}
	
	/**
	 * Get the user's school name. 
	 * @return the school name 
	 */
	public String getSchoolName() {
		return this.schoolName; 
	}
	
	/**
	 * Set the user's school name. 
	 * @param schoolName
	 */
	private void setSchoolName(String schoolName) {
		this.schoolName = schoolName; 
	}
	
	/**
	 * Get the user's first name. 
	 * @return the firstName
	 */
	public String getFirstName() {
		return this.firstName; 
	}
	
	/**
	 * Set the user's first name. 
	 * @param firstName
	 */
	private void setFirstName(String firstName) {
		this.firstName = firstName; 
	}
	
	/**
	 * Get the user's last name. 
	 * @return the lastName 
	 */
	public String getLastName() {
		return this.lastName; 
	}
	
	/**
	 * Set the user's last name. 
	 * @param lastName
	 */
	private void setLastName(String lastName) {
		this.lastName = lastName; 
	}
	
	/**
	 * Get the user's password. 
	 * @return the password
	 */
	public String getPassword() {
		return this.password; 
	}
	
	/**
	 * Set the user's password. 
	 * @param password
	 */
	private void setPassword(String password) {
		this.password = password; 
	}
	
	/**
	 * Get the user's date of birth. 
	 * @return ther dateOfBirth
	 */
	public String dateOfBirth() {
		return this.dateOfBirth; 
	}
	
	/** 
	 * Set the user's date of birth. 
	 * @param dateOfBirth
	 */
	private void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth; 
	}
}
