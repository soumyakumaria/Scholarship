package Login;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import scholarship.Scholarship;
import users.ScholarshipCoordinator;
import users.Student;
import users.User;

/**
 * @author cam
 * Methods used in multiple places throughout the program, mostly focused
 * on the file system.
 */
public class Utilities {
	
	/**
	 * @return a list of all Scholarship objects stored in scholarships.txt.
	 */
	public static Scholarship[] loadScholarships() {
		try {
			File file = new File("scholarships.txt");
			Scanner in = new Scanner(file);
			int n = 0;
			while(in.hasNextLine()) {
				n++;
				in.nextLine();
			}
			in = new Scanner(file);
			Scholarship[] a = new Scholarship[n / 10];
			
			int i = 0;
			while (i < (n / 10)) {
				Scholarship s = new Scholarship();
				s.setName(in.nextLine());
				s.setMinGPA(in.nextLine());
				s.setAntirequisite(in.nextLine());
				s.setNumAvailable(Integer.parseInt(in.nextLine()));
				s.setNominations(in.nextLine().split("/"));
				s.setGrant(in.nextLine().equals("true"));
				s.setDescription(in.nextLine());
				s.setMoney(Double.parseDouble(in.nextLine()));
				s.setFrequency(in.nextLine());
				s.setDuration(in.nextLine());
				a[i] = s;
				i++;
			}
			
			in.close();
			return a;
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Saves a Scholarship object to scholarships.txt. WARNING: all 10 member variables
	 * must be initialized or the method will throw an error.
	 * @param s the Scholarship object to be saved.
	 */
	public static void saveScholarship(Scholarship s) {
		try {
			BufferedWriter w = new BufferedWriter(new FileWriter("scholarships.txt", true));
			w.write(s.getName() + "\n");
			w.write(s.getMinGPA() + "\n");
			w.write(s.getAntirequisite() + "\n");
			w.write(s.getNumAvailable() + "\n");
			String nominations = "";
			String[] temp = s.getNominations();
			for(int i = 0; i < temp.length; i ++) {
				nominations += temp[i];
				if (i != temp.length - 1)
					nominations += "/";
			}
			w.write(nominations + "\n");
			w.write(s.isGrant() + "\n");
			w.write(s.getDescription() + "\n");
			w.write(s.getMoney() + "\n");
			w.write(s.getFrequency() + "\n");
			w.write(s.getDuration() + "\n");
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param a the array of scholarships to look through
	 * @param name the name to look for
	 * @return a Scholarship from the given array that has the given name.
	 * Returns null if no such Scholarship is found.
	 */
	public static Scholarship getScholarship(Scholarship[] a, String name) {
		for (Scholarship s : a) {
			if (s.getName().equals(name)) {
				return s;
			}
		}
		return null;
	}
	
	/**
	 * @param a the array of Students to look through
	 * @param fName the first name to look for
	 * @param lName the last name to look for
	 * @return a Student from the given array that has the given first and lastname.
	 * Returns null if no such Student is found.
	 */
	public static Student getStudent(Student[] a, String fName, String lName) {
		for (Student s : a) {
			if (s.getFirstName().equals(fName) && s.getLastName().equals(lName)) {
				return s;
			}
		}
		return null;
	}
	
	/**
	 * Removes all elements equal to null in a given Scholarship array.
	 * @param a Scholarship array
	 * @return an array with the same Scholarships as the given array, but without null values.
	 * Length may be different than that of the given array due to removed null values.
	 */
	public static Scholarship[] trimArray(Scholarship[] a) {
		int n = 0;
		for (Scholarship s : a) {
			if (s != null)
				n++;
		}
		Scholarship[] b = new Scholarship[n];
		int m = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != null) 
				b[i - m] = a[i];
			else
				m++;
		}
		return b;
	}
	
	/**
	 * Returns an array of all Scholarships with a required GPA less than or equal to
	 * the given double.
	 * @param a array of all Scholarships
	 * @param GPA the desired GPA
	 * @return
	 */
	public static Scholarship[] sortGPA(Scholarship[] a, double GPA) {
		Scholarship[] b = new Scholarship[a.length];
		for (int i = 0; i < a.length; i++) {
			if (Double.parseDouble(a[i].getMinGPA()) <= GPA)
				b[i] = a[i];
		}
		return trimArray(b);
	}
	
	/**
	 * Returns a list of all Scholarships that allow the given letter grade, as well as
	 * all letter grades below it. E.g. all Scholarships with an antirequisite less than
	 * the given letter grade. W is independent, so an antirequisite 'C' or 'F' etc can
	 * still allow W's.
	 * @param a array of all scholarships
	 * @param grade the letter grade (W,F,D-,D,D+,C-,C,C+,B-,B,B+,A-,A,A+) to check against
	 * antirequisites.
	 * @return
	 */
	public static Scholarship[] sortAntirequisite(Scholarship[] a, String grade) {
		String grades = "F,D-,D,D+,C-,C,C+,B-,B,B+,A-,A,A+";
		if (grade.equalsIgnoreCase("W")) {
			grades = "Ww";
		} else {
			grades = grades.substring(grades.indexOf(grade), grades.length());
		}
		Scholarship[] b = new Scholarship[a.length];
		for (int i = 0; i < a.length; i++) {
			if (!grades.contains(a[i].getAntirequisite()))
				b[i] = a[i];
		}
		return trimArray(b);
	}
	
	/**
	 * Returns a list of all Scholarships that the given Student is legible for, based on
	 * their GPA and individual letter grades.
	 * @param a list of all Scholarships
	 * @param s student to check against
	 * @return
	 */
	public static Scholarship[] sortLegible(Scholarship[] a, Student s) {
		Scholarship[] b = a;
		for (String temp : s.getGrades().split(",")) {
			b = sortAntirequisite(b, temp);
		}
		return sortGPA(b, s.getGPA());
	}
	
	/**
	 * @param a array to add to
	 * @param s Student to add to the array
	 * @return array a with s appended to it(will be greater in length than the original array).
	 */
	public static Student[] addStudent(Student[] a, Student s) {
		Student[] b = new Student[a.length + 1];
		for (int i = 0; i < a.length; i++)
			b[i] = a[i];
		b[a.length] = s;
		return b;
	}
	
	
	
	/**
	 * @return an array of all Student objects stored in students.txt
	 */
	public static Student[] loadStudents() {
		File f = new File("students.txt");
		Scholarship[] sch = loadScholarships();
		Student[] arr = new Student[0];
		try {
			Scanner in = new Scanner(f);
			while(in.hasNextLine()) {
				Student st = new Student();
				st.initializeScholarships();
				st.setFirstName(in.nextLine());
				st.setLastName(in.nextLine());
				st.setDateOfBirth(in.nextLine() + " " + in.nextLine() + " " + in.nextLine());
				st.setSchoolName(in.nextLine());
				st.setSchoolEmail(in.nextLine());
				st.setSchoolID(in.nextLine());
				st.setPassword(in.nextLine());
				String temp = in.nextLine();
				for (String scholName : temp.split(",")) {
					if(!scholName.equals(""))
						st.addPending(Utilities.getScholarship(sch, scholName));
				}
				temp = in.nextLine();
				for (String scholName : temp.split(",")) {
					if(!scholName.equals(""))	
						st.addAwaiting(Utilities.getScholarship(sch, scholName));
				}
				temp = in.nextLine();
				for (String scholName : temp.split(",")) {
					if(!scholName.equals(""))
						st.addAccepted(Utilities.getScholarship(sch, scholName));
				}
				st.setGrades(in.nextLine());
				arr = addStudent(arr, st);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	private static boolean schArrayContains(Scholarship[] a, Scholarship sch) {
		for (Scholarship temp : a) {
			if (temp.getName().equals(sch.getName()))
				return true;
		}
		return false;
			
	}
	
	/**
	 * Used in this class to reduce repetition. Finds all Students in students.txt that
	 * have the given Scholarship in their pending, awaiting, or accepted arrays.
	 * @param sch the Scholarship to search for.
	 * @param which Determines which array to search in each student:
	 * 		  0: pending
	 * 		  1: awaiting
	 * 		  2: accepted
	 * @return all Students in students.txt that have sch in pending/awaiting/accepted.
	 */
	private static Student[] filterBySchStatus(Scholarship sch, int which) {
		Student[] arr = new Student[0];
		for (Student st : loadStudents()) {
			if (schArrayContains(which == 0 ? st.getPending() : (which == 1 ? st.getAwaiting() : st.getAccepted()), sch)) {
				arr = addStudent(arr, st);
				continue;
			}
				
		}
		return arr;
	}
	
	/**
	 * @param sch the Scholarship to search for.
	 * @return all students in students.txt that have sch in their pending array.
	 */
	public static Student[] filterByPending(Scholarship sch) {
		return filterBySchStatus(sch, 0);
	}
	
	/**
	 * @param sch the Scholarship to search for.
	 * @return all students in students.txt that have sch in their awaiting array.
	 */
	public static Student[] filterByAwaiting(Scholarship sch) {
		return filterBySchStatus(sch, 1);
	}
	
	/**
	 * @param sch the Scholarship to search for.
	 * @return all students in students.txt that have sch in their accepted array.
	 */
	public static Student[] filterByAccepted(Scholarship sch) {
		return filterBySchStatus(sch, 2);
	}
	
	/**
	 * Used to reduce repetition in Utilities; writes a given array of strings to a file,
	 * with each element separated by a newline. Overwrites contents of existing file.
	 * @param fileName the file to overwite.
	 * @param a array of strings to write.
	 */
	private static void overwriteFile(String fileName, String[] a) {
		try {
			BufferedWriter w = new BufferedWriter(new FileWriter(fileName, false));
			for(String str : a)
				w.append(str + "\n");
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Used to reduce repetition in Utilities; returns the contents of a file.
	 * @param fileName the file to search.
	 * @return an array of strings. Each element represents a line from the file.
	 */
	private static String[] getFileContents(String fileName) {
		File f = new File(fileName);
		String[] a = new String[0];
		try {
			Scanner in = new Scanner(f);
			String fileContents = "";
			while(in.hasNextLine())
				fileContents += in.nextLine() + "\n";
			in.close();
			a = fileContents.split("\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	/**
	 * Appends a Scholarship to a User's position in a text file; works for both
	 * ScholarshipCoordinators and Students.
	 * @param fileName name of the file to append to.
	 * @param whichArr indicates which array of Scholarships to append to:
	 * 		  1: pending or myScholarships
	 * 		  2: awaiting or awardedScholarships
	 * 		  3: accepted or pendingScholarships
	 * @param sch the scholarship to append.
	 * @param u the user to add the scholarship to.
	 */
	public static void appendScholarship(String fileName, int whichArr, Scholarship sch, User u) {
		String[] a = getFileContents(fileName);
		for (int i = 0; i < a.length; i ++) {
			if (a[i].equals(u.getSchoolEmail())) {
				if(!a[i + 2 + whichArr].equals(""))
					a[i + 2 + whichArr] += ",";
				a[i + 2 + whichArr] += sch.getName();
				break;
			}
		}
		overwriteFile(fileName, a);
	}
	
	/**
	 * Removes a Scholarship from a User's position in a text file; works for both
	 * ScholarshipCoordinators and Students.
	 * @param fileName name of the file to remove from.
	 * @param whichArr indicates which array of Scholarships to remove from:
	 * 		  1: pending or myScholarships
	 * 		  2: awaiting or awardedScholarships
	 * 		  3: accepted or pendingScholarships
	 * @param sch the scholarship to remove.
	 * @param u the user to remove the scholarship from.
	 */
	public static void removeScholarship(String fileName, int whichArr, Scholarship sch, User u) {
		String[] a = getFileContents(fileName);
		for (int i = 0; i < a.length; i ++) {
			if (a[i].equals(u.getSchoolEmail())) {
				a[i += (2 + whichArr)] = a[i].replace(sch.getName(), "").replace(",,", ",");
				if (!a[i].equals("")) {
					if (a[i].substring(0, 1).equals(","))
						a[i] = a[i].replaceFirst(",", "");
					if (a[i].substring(a[i].length() - 1, a[i].length()).equals(","))
						a[i] = a[i].substring(0, a[i].length() - 1);
				}
				break;
			}
		}
		overwriteFile(fileName, a);
	}
	
}
