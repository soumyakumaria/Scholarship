package scholarship;

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
	
	public Course[] getCourses() {
		return courses;
	}

	public Scholarship[] getPending() {
		return pending;
	}

	public Scholarship[] getAwaiting() {
		return awaiting;
	}

	public Scholarship[] getNotAccepted() {
		return notAccepted;
	}

	public int getGPA() {
		return GPA;
	}

	public boolean hasGrade(String grade) {
		if(grade == "W" | grade == "F") {
			return false;
		}
		else{
			return true;
		}
	}


	
}
