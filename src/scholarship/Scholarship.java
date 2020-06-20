package scholarship;

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
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMinGPA() {
		return minGPA;
	}
	
	public void setMinGPA(String minGPA) {
		this.minGPA = minGPA;
	}
	
	public String getAntirequisite() {
		return antirequisite;
	}
	
	public void setAntirequisite(String antirequisite) {
		this.antirequisite = antirequisite;
	}
	
	public int getNumAvailable() {
		return numAvailable;
	}
	
	public void setNumAvailable(int numAvailable) {
		this.numAvailable = numAvailable;
	}
	
	public String[] getNominations() {
		return nominations;
	}
	
	public void setNominations(String[] nominations) {
		this.nominations = nominations;
	}
	
	public boolean isGrant() {
		return grant;
	}
	
	public void setGrant(boolean grant) {
		this.grant = grant;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getMoney() {
		return money;
	}
	
	public void setMoney(double money) {
		this.money = money;
	}
	
	public String getFrequency() {
		return frequency;
	}
	
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	
	public String getDuration() {
		return duration;
	}
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
}
