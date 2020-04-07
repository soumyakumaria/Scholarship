package users;

import scholarship.Scholarship;

/**
 * This is the initial Student class created for iteration 2 
 * @author Shamim, cam 
 *
 */
public class Student extends User {
	private String grades;
	private Scholarship[] pending;
	private Scholarship[] awaiting;
	private Scholarship[] notAccepted;
	
	
	/**
	 * sets all Scholarship arrays to a length of 0
	 */
	public void initializeScholarships() {
		pending = new Scholarship[0];
		awaiting = new Scholarship[0];
		notAccepted = new Scholarship[0];
	}
	
	/**
	 * @param s add this Scholarship to pending
	 */
	public void addPending(Scholarship s) {
		pending = addScholarship(pending, s);
	}
	
	/**
	 * @param s add this Scholarship to awaiting
	 */
	public void addAwaiting(Scholarship s) {
		awaiting = addScholarship(awaiting, s);
	}
	
	/**
	 * @param s add this Scholarship to notAccepted
	 */
	public void addNotAccepted(Scholarship s) {
		notAccepted = addScholarship(notAccepted, s);
	}

	/**
	 * Get the list of pending scholarships. 
	 * @return the pending
	 */
	public Scholarship[] getPending() {
		return pending;
	}

	/**
	 * Get the list of awaiting scholarships. 
	 * @return the awaiting
	 */
	public Scholarship[] getAwaiting() {
		return awaiting;
	}

	/**
	 * Get the list of not accepted scholarships. 
	 * @return the notAccepted
	 */
	public Scholarship[] getNotAccepted() {
		return notAccepted;
	}
	
	public void setPending(Scholarship[] pending) {
		this.pending = pending;
	}

	public void setAwaiting(Scholarship[] awaiting) {
		this.awaiting = awaiting;
	}

	public void setNotAccepted(Scholarship[] notAccepted) {
		this.notAccepted = notAccepted;
	}

	/**
	 * @return grades, formatted as: "A,A+,F,B-,..."
	 */
	public String getGrades() {
		return grades;
	}

	/**
	 * @param grades must follow format: "A,A+,F,W,A,..."
	 */ 
	public void setGrades(String grades) {
		this.grades = grades;
	}

	/**
	 * Get the student's GPA. 
	 * @return the GPA
	 */
	public double getGPA() {
		String[] letters = new String[] {"F", "D", "D+", "C-", "C", "C+", "B-", "B", "B+", "A-", "A", "A+"};
		double[] numbers = new double[] {0, 1, 1.3, 1.7, 2, 2.3, 2.7, 3, 3.3, 3.7, 4, 4};
		String[] gradesArr = grades.split(",");
		double cumulativeGPA = 0;
		int wCount = 0;
		for (String s : gradesArr) {
			if( s.equals("W")) {
				wCount++;
			} else {
				for (int i = 0; i < letters.length; i++) {
					if (letters[i].equals(s)) {
						cumulativeGPA += numbers[i];
						break;
					}
				}
			}
			
		}
		return cumulativeGPA/(gradesArr.length - wCount);
	}

	/**
	 * Checks if student has a given grade. 
	 * @return boolean value hasGrade
	 */
	public boolean hasGrade(String grade) {
		return grades.contains(grade);
	}


	
}
