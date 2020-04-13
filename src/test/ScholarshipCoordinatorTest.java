package test;

import static org.junit.Assert.*;

import java.awt.EventQueue;

import org.junit.Test;

import Login.LoginScreen;
import Login.Utilities;
import scholarship.Scholarship;
import users.ScholarshipCoordinator;
import users.User; 

/**
 * This class contains the test cases for the ScholarshipCoordinator class. 
 * @author Tiffany 
 *
 */
public class ScholarshipCoordinatorTest {
	
	public static User user = new User(); 
	private final ScholarshipCoordinator sc = new ScholarshipCoordinator(); 
	private final Scholarship s = new Scholarship(); 
	
	/**
	 * Test method for {@link users.ScholarshipCoordinator#addMyScholarship(scholarship.Scholarship)}.
	 */
	@Test
	public void testAddMyScholarship() {
		Scholarship[] myScholarships = new Scholarship[0];
		myScholarships = user.addScholarship(myScholarships, s);
		String[] expected = null; 
		assertEquals("Array is intialized and is empty.", expected, sc.getMyScholarships()); 
	}

	/**
	 * Test method for {@link users.ScholarshipCoordinator#addAwardedScholarship(scholarship.Scholarship)}.
	 */
	@Test
	public void testAddAwardedScholarship() {
		Scholarship[] awardedScholarships = new Scholarship[0];
		awardedScholarships = user.addScholarship(awardedScholarships, s);
		String[] expected = null; 
		assertEquals("Array is intialized and is empty.", expected, sc.getAwardedScholarships());
	}

	/**
	 * Test method for {@link users.ScholarshipCoordinator#addPendingScholarship(scholarship.Scholarship)}.
	 */
	@Test
	public void testAddPendingScholarship() {
		Scholarship[] pendingScholarships = new Scholarship[0];
		pendingScholarships = user.addScholarship(pendingScholarships, s);
		String[] expected = null; 
		assertEquals("Array is intialized and is empty.", expected, sc.getPendingScholarships());
	}

	/**
	 * Test method for {@link users.ScholarshipCoordinator#getMyScholarships()}.
	 */
	@Test
	public void testGetMyScholarships() {
		Scholarship[] myScholarships = new Scholarship[0];
		myScholarships = user.addScholarship(myScholarships, s);
		assertNull("Array initialized and should be: ", sc.getMyScholarships());
	}

	/**
	 * Test method for {@link users.ScholarshipCoordinator#getAwardedScholarships()}.
	 */
	@Test
	public void testGetAwardedScholarships() {
		Scholarship[] awardedScholarships = new Scholarship[0];
		awardedScholarships = user.addScholarship(awardedScholarships, s);
		assertNull("Array initialized and should be: ", sc.getAwardedScholarships());
	}

	/**
	 * Test method for {@link users.ScholarshipCoordinator#getPendingScholarships()}.
	 */
	@Test
	public void testGetPendingScholarships() {
		Scholarship[] pendingScholarships = new Scholarship[0];
		pendingScholarships = user.addScholarship(pendingScholarships, s);
		assertNull("Array initialized and should be: ", sc.getPendingScholarships());
	}
}
