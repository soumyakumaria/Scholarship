package users;

import scholarship.Scholarship;

/**
 * This is the initial ScholarshipCoordinator class created for iteration 2 
 * @author Tiffany, cam
 *
 */
public class ScholarshipCoordinator extends User{
	
	private Scholarship[] myScholarships;
	private Scholarship[] awardedScholarships; 
	private Scholarship[] pendingScholarships; 
	private String[] recipients; 
	
	/**
	 * Sets all Scholarship arrays to a length of 0
	 */
	public void initializeScholarships() {
		myScholarships = new Scholarship[0];
		awardedScholarships = new Scholarship[0];
		pendingScholarships = new Scholarship[0];
	}
	
	/**
	 * @param s add this Scholarship to awardedScholarships
	 */
	public void addMyScholarship(Scholarship s) {
		myScholarships = addScholarship(myScholarships, s);
	}
	
	/**
	 * @param s add this Scholarship to myScholarships
	 */
	public void addAwardedScholarship(Scholarship s) {
		awardedScholarships = addScholarship(awardedScholarships, s);
	}
	
	/**
	 * @param s add this Scholarship to pendingScholarships
	 */
	public void addPendingScholarship(Scholarship s) {
		pendingScholarships = addScholarship(pendingScholarships, s);
	}

	/**
	 * Get the list of scholarships created by this user. 
	 * @return the myScholarships
	 */
	public Scholarship[] getMyScholarships() {
		return myScholarships;
	}

	/**
	 * Get the list of scholarships that have already been awarded to student. 
	 * @return the awardedScholarships
	 */
	public Scholarship[] getAwardedScholarships() {
		return awardedScholarships;
	}

	/**
	 * Get the list of scholarships that have been offered to students but have not been accepted. 
	 * @return the pendingScholarships
	 */
	public Scholarship[] getPendingScholarships() {
		return pendingScholarships;
	}

	/**
	 * Get the list of recipients for each scholarship. 
	 * @return the recipients
	 */
	public String[] getRecipients() {
		
		return recipients;
	}

	
}
