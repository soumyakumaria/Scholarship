/**
 * This is the initial Student class created for iteration 2 
 * @author Shamim 
 *
 */
public class Student extends User {
	private Course[] courses;
	private Scholarship[] pending;
	private Scholarship[] awaiting;
	private Scholarship[] notAccepted;
	private int GPA;
	
	/**
	 * Get the list of courses of the student. 
	 * @return the courses
	 */
	public Course[] getCourses() {
		return courses;
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

	/**
	 * Get the student's GPA. 
	 * @return the GPA
	 */
	public int getGPA() {
		return GPA;
	}

	/**
	 * Checks if student has a grade above F or W. 
	 * @return boolean value hasGrade
	 */
	public boolean hasGrade(String grade) {
		if(grade == "W" | grade == "F") {
			return false;
		}
		else{
			return true;
		}
	}


	
}
