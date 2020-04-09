package Login;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import scholarship.Scholarship;
import users.Student;

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
			w.write("\n" + s.getName() + "\n");
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
	 * Used to reduce repetition in sorting methods. Removes all elements equal to null in
	 * a given Scholarship array.
	 * @param a Scholarship array
	 * @return an array with the same Scholarships as the given array, but without null values.
	 * Length may be different than that of the given array due to removed null values.
	 */
	private static Scholarship[] trimArray(Scholarship[] a) {
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
	
}
