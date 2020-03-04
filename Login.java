package utilities;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

/**
 * @author Cam Hermann
 * Temporary, first iteration of a login system. Will be combined with GUI and refined for 
 * iteration 2.
 */

public class Login {
	
	/**
	 * Prompts the user with a message, then returns input from the given Scanner. Used to reduce repetition.
	 * @param s prompt to be displayed to user.
	 * @param in Scanner used to read input.
	 * @return input from the Scanner in.
	 */
	public static String getString(String s, Scanner in) {
		System.out.println(s);
		return in.nextLine();
	}
	
	/**
	 * Prompts the user with a message, then returns integer input from the given Scanner, between min and max(inclusive). Used to reduce repetition.
	 * @param s prompt to be displayed to user.
	 * @param in Scanner used to read input.
	 * @return input from the Scanner in.
	 */
	public static int getInt(String s, int min, int max, Scanner in) {
		System.out.println(s);
		int n = 0;
		try {
			n = Integer.parseInt(in.nextLine());
			return (n >= min && n <= max) ? n : getInt("Please enter an integer between " + min + " and " + max + ".", min, max, in);
		} catch (Exception e) {
			return getInt("Please enter an integer.", min, max, in);
		}
		
	}
	
	/**
	 * Creates a new user with the given array of attributes by storing them in users.txt.
	 * @param attributes a String array(length 9) of user attributes; first name, last name, birth year, birth
	 * month, birth day, school name, school email, school ID, and password. Attributes are temporary and will
	 * likely change in iteration 2.
	 */
	public static void createUser(String[] attributes) {
		File users = new File("users.txt");
		
			try {
				users.createNewFile();
				BufferedWriter w = new BufferedWriter(new FileWriter("users.txt", true));
				for (int i = 0; i < 9; i ++) 
					w.write(attributes[i] + "\n");
				w.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}
	
	/**
	 * Checks if the given email exists in users.txt, and if the corresponding password is correct. User is notified if login was a success
	 * only after checking password.
	 * @param email user's email.
	 * @param password user's password.
	 */
	public static void login(String email, String password) {
		File users = new File("users.txt");
		try {
			Scanner read = new Scanner(users);
			String temp = "";
			while(!temp.equals(email) && read.hasNextLine())
				temp = read.nextLine();
			
			if(read.hasNextLine()) {
				read.nextLine();
				temp = read.nextLine();
			}
			read.close();
			if(!temp.equals(password)) {
				System.out.println("email or password is incorrect.");
				return;
			}
			
			System.out.println("Success!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * Temporary; used to test login system.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		if (getString("press l to log in, or c to create a new account", in).equals("c")) {
			getString("Are you student or staff?", in);// Currently has no effect, will change when ScholarshipCoordinator and Student are implemented.
			String[] a = new String[9];
			a[0] = getString("Enter your first name:", in);
			a[1] = getString("Enter your last name:", in);
			a[2] = Integer.toString(getInt("Enter your birth year:", 1880, 2020, in));
			a[3] = Integer.toString(getInt("Enter your birth month:", 1, 12, in));
			a[4] = Integer.toString(getInt("Enter your birth day:", 1, 31, in));
			a[5] = getString("Enter your school's name:", in);
			a[6] = getString("Enter your school email:", in);
			a[7] = getString("Enter your school ID:", in);
			a[8] = getString("Enter your password:", in);
			createUser(a);
		} else {
			login(getString("Enter your email:", in), getString("Enter your password:", in));
		}
		
	}
	
}
