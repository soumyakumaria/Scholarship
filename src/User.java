/**
 * This is the initial User class created for iteration 2 
 * @author Tiffany 
 *
 */
public class User {
	private String name; 
	private String schoolEmail; 
	private String password; 
	private String dateOfBirth; 
	private String ucid; 
	
	/**
	 * Constructor
	 */
	public User() {
		
	}
	
	public String getName() {
		return this.name; 
	}
	
	public void setName(String name) {
		this.name = name; 
	}
	
	public String getSchoolEmail() {
		return this.schoolEmail; 
	}
	
	public void setSchoolEmail(String schoolEmail) {
		this.schoolEmail = schoolEmail; 
	}
	
	public String getPassword() {
		return this.password; 
	}
	
	public void setPassword(String password) {
		this.password = password; 
	}
	
	public String dateOfBirth() {
		return this.dateOfBirth; 
	}
	
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth; 
	}
	
	public String getUcid() {
		return this.ucid; 
	}
	
	public void setUcid(String ucid) {
		this.ucid = ucid; 
	}
}
