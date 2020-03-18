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
	
	public String getSchoolEmail() {
		return this.schoolEmail; 
	}
	
	private void setSchoolEmail(String schoolEmail) {
		this.schoolEmail = schoolEmail; 
	}
	
	public String getSchoolID() {
		return this.schoolID; 
	}
	
	private void setSchoolID(String schoolID) {
		this.schoolID = schoolID; 
	}
	
	public String getSchoolName() {
		return this.schoolName; 
	}
	
	private void setSchoolName(String schoolName) {
		this.schoolName = schoolName; 
	}
	
	public String getFirstName() {
		return this.firstName; 
	}
	
	private void setFirstName(String firstName) {
		this.firstName = firstName; 
	}
	
	public String getLastName() {
		return this.lastName; 
	}
	
	private void setLastName(String lastName) {
		this.lastName = lastName; 
	}
	
	public String getPassword() {
		return this.password; 
	}
	
	private void setPassword(String password) {
		this.password = password; 
	}
	
	public String dateOfBirth() {
		return this.dateOfBirth; 
	}
	
	private void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth; 
	}
}
