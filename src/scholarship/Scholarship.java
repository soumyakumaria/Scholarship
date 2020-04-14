package scholarship;

/**
 * This is the initial Scholarship class created for iteration 2 
 * @author Shamim 
 *
 */
/**
 * @author Soumya
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
	private String acceptDeclineDate;
	private String level;
	private String studentType;
	
	public String getAcceptDeclineDate() {
		return acceptDeclineDate;
	}
	
	/**
	 * @param acceptDeclineDate
	 */
	public void setAcceptDeclineDate(String acceptDeclineDate) {
		this.acceptDeclineDate = acceptDeclineDate;
	}

	/**
	 * @return
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * @param level
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * @return
	 */
	public String getStudentType() {
		return studentType;
	}

	/**
	 * @param studentType
	 */
	public void setStudentType(String studentType) {
		this.studentType = studentType;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return
	 */
	public String getMinGPA() {
		return minGPA;
	}
	
	/**
	 * @param minGPA
	 */
	public void setMinGPA(String minGPA) {
		this.minGPA = minGPA;
	}
	
	/**
	 * @return
	 */
	public String getAntirequisite() {
		return antirequisite;
	}
	
	/**
	 * @param antirequisite
	 */
	public void setAntirequisite(String antirequisite) {
		this.antirequisite = antirequisite;
	}
	
	/**
	 * @return
	 */
	public int getNumAvailable() {
		return numAvailable;
	}
	
	/**
	 * @param numAvailable
	 */
	public void setNumAvailable(int numAvailable) {
		this.numAvailable = numAvailable;
	}
	
	/**
	 * @return
	 */
	public String[] getNominations() {
		return nominations;
	}
	
	/**
	 * @param nominations
	 */
	public void setNominations(String[] nominations) {
		this.nominations = nominations;
	}
	
	/**
	 * @return
	 */
	public boolean isGrant() {
		return grant;
	}
	
	/**
	 * @param grant
	 */
	public void setGrant(boolean grant) {
		this.grant = grant;
	}
	
	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @return
	 */
	public double getMoney() {
		return money;
	}
	
	/**
	 * @param money
	 */
	public void setMoney(double money) {
		this.money = money;
	}
	
	/**
	 * @return
	 */
	public String getFrequency() {
		return frequency;
	}
	
	/**
	 * @param frequency
	 */
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	
	/**
	 * @return
	 */
	public String getDuration() {
		return duration;
	}
	
	/**
	 * @param duration
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}
}
