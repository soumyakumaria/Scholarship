/**
 * This is the initial Scholarship class created for iteration 2 
 * @author Shamim 
 *
 */
public class Scholarship {
	private String name;
	private String minGPA;
	private String antirequisite;
	private int numAvailable;
	private String[] nominations;
	private boolean grant;
	private String description;
	private double money;
	private String frequency;
	private String duration;
	
	/**
	 * Get the name of the scholarship. 
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set the name of the scholarship. 
	 * @param name the name to set
	 */
	private void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Get the minimum GPA. 
	 * @return the min GPA
	 */
	public String getMinGPA() {
		return minGPA;
	}
	
	/**
	 * Set the minimum GPA for the scholarship. 
	 * @param minGPA the minGPA to set
	 */
	private void setMinGPA(String minGPA) {
		this.minGPA = minGPA;
	}
	
	/**
	 * Get the antirequisite. 
	 * @return the antirequisite
	 */
	public String getAntirequisite() {
		return antirequisite;
	}
	
	/**
	 * Set the antirequisite of the scholarship. 
	 * @param antirequisite the antirequisite to set
	 */
	private void setAntirequisite(String antirequisite) {
		this.antirequisite = antirequisite;
	}
	
	/**
	 * Get the number of available scholarships. 
	 * @return the number of available scholarships
	 */
	public int getNumAvailable() {
		return numAvailable;
	}
	
	/**
	 * Set the number of scholarships available. 
	 * @param numAvailable the numAvailable to set
	 */
	private void setNumAvailable(int numAvailable) {
		this.numAvailable = numAvailable;
	}
	
	/**
	 * Get the nominations. 
	 * @return the nominations
	 */
	public String[] getNominations() {
		return nominations;
	}
	
	/**
	 * Set the nominations for the scholarship.
	 * @param nominations the nominations to set
	 */
	private void setNominations(String[] nominations) {
		this.nominations = nominations;
	}
	
	/**
	 * 
	 * @return grant
	 */
	public boolean isGrant() {
		return grant;
	}
	
	/**
	 * 
	 * @param
	 */
	private void setGrant(boolean grant) {
		this.grant = grant;
	}
	
	/**
	 * Get the description of the scholarship. 
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Set the description for the scholarship.
	 * @param description the description to set
	 */
	private void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Get the amount of money. 
	 * @return amount of money
	 */
	public double getMoney() {
		return money;
	}
	
	/**
	 * Set the amount of money of the scholarship.
	 * @param money the money to set
	 */	
	private void setMoney(double money) {
		this.money = money;
	}
	
	/**
	 * Get the frequency of the scholarship. 
	 * @return the frequency
	 */
	public String getFrequency() {
		return frequency;
	}
	
	/**
	 * Set the frequency of the scholarship.
	 * @param frequency the frequency to set
	 */	
	private void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	
	/**
	 * Get the duration of the scholarship. 
	 * @return the duration
	 */
	public String getDuration() {
		return duration;
	}
	
	/**
	 * Set the duration of the scholarship.
	 * @param duration the duration to set
	 */
	private void setDuration(String duration) {
		this.duration = duration;
	}
}
