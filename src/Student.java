package scholarship;

/**
 * This is the initial User class created for iteration 2 
 * @author Shamim 
 *
 */
public class Student extends User {
	private Course courses;
	private Scholarship pending;
	private Scholarship awaiting;
	private Scholarship notAccepted;
	private int GPA;
	
	public Course getCourses() {
		return courses;
	}
	public void setCourses(Course courses) {
		this.courses = courses;
	}
	public Scholarship getPending() {
		return pending;
	}
	public void setPending(Scholarship pending) {
		this.pending = pending;
	}
	public Scholarship getAwaiting() {
		return awaiting;
	}
	public void setAwaiting(Scholarship awaiting) {
		this.awaiting = awaiting;
	}
	public Scholarship getNotAccepted() {
		return notAccepted;
	}
	public void setNotAccepted(Scholarship notAccepted) {
		this.notAccepted = notAccepted;
	}
	public int getGPA() {
		return GPA;
	}
	public void setGPA(int gPA) {
		GPA = gPA;
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
