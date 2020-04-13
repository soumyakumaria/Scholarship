package test;

import static org.junit.Assert.*;

import org.junit.Test;

import users.User;

/**
 * This class contains the test cases for the User class. 
 * @author Tiffany 
 *
 */
public class UserTest {

	private final User user = new User(); 

	/**
	 * Test method for {@link users.User#getSchoolEmail()}.
	 */
	@Test
	public void testGetSchoolEmail() {
		user.setSchoolEmail("harrypotter@emu.ca");
		assertNotNull("Email should not be empty.", user.getSchoolEmail()); 
	}

	/**
	 * Test method for {@link users.User#setSchoolEmail(java.lang.String)}.
	 */
	@Test
	public void testSetSchoolEmail() {
		user.setSchoolEmail("harrypotter@emu.ca");
		String expected = "harrypotter@emu.ca";  
		assertEquals("The school email should be: ", expected, user.getSchoolEmail()); 
	}

	/**
	 * Test method for {@link users.User#getSchoolID()}.
	 */
	@Test
	public void testGetSchoolID() {
		user.setSchoolID("1234567");
		assertNotNull("School ID should not be empty", user.getSchoolID());
	}

	/**
	 * Test method for {@link users.User#setSchoolID(java.lang.String)}.
	 */
	@Test
	public void testSetSchoolID() {
		user.setSchoolID("1234567");
		String expected = "1234567"; 
		assertEquals("The school id should be: ", expected, user.getSchoolID());
	}

	/**
	 * Test method for {@link users.User#getSchoolName()}.
	 */
	@Test
	public void testGetSchoolName() {
		user.setSchoolID("Hogwarts");
		assertNotNull("School name should not be empty", user.getSchoolName());
	}

	/**
	 * Test method for {@link users.User#setSchoolName(java.lang.String)}.
	 */
	@Test
	public void testSetSchoolName() {
		user.setSchoolID("Hogwarts");
		String expected = "Hogwarts";
		assertEquals("The school name should be: ", expected, user.getSchoolName());
	}

	/**
	 * Test method for {@link users.User#getFirstName()}.
	 */
	@Test
	public void testGetFirstName() {
		user.setFirstName("Harry");
		assertNotNull("First name should not be empty.", user.getFirstName());
	}

	/**
	 * Test method for {@link users.User#setFirstName(java.lang.String)}.
	 */
	@Test
	public void testSetFirstName() {
		user.setFirstName("Harry");
		String expected = "Harry"; 
		assertEquals("First name should be: ", expected, user.getFirstName()); 
	}

	/**
	 * Test method for {@link users.User#getLastName()}.
	 */
	@Test
	public void testGetLastName() {
		user.setLastName("Potter");
		assertNotNull("Last Name should not be empty.", user.getLastName()); 
	}

	/**
	 * Test method for {@link users.User#setLastName(java.lang.String)}.
	 */
	@Test
	public void testSetLastName() {
		user.setLastName("Potter");
		String expected = "Potter"; 
		assertEquals("Last name should be: ", expected, user.getLastName()); 
	}

	/**
	 * Test method for {@link users.User#getPassword()}.
	 */
	@Test
	public void testGetPassword() {
		user.setPassword("quidditch");
		assertNotNull("Password should not be empty.", user.getPassword()); 
	}

	/**
	 * Test method for {@link users.User#setPassword(java.lang.String)}.
	 */
	@Test
	public void testSetPassword() {
		user.setPassword("quidditch");
		String expected = "quidditch"; 
		assertEquals("Password should be: ", expected, user.getPassword()); 
	}

	/**
	 * Test method for {@link users.User#dateOfBirth()}.
	 */
	@Test
	public void testDateOfBirth() {
		user.setDateOfBirth("July 31 1980");
		assertNotNull("Date of birth should not be empty.", user.dateOfBirth()); 
	}

	/**
	 * Test method for {@link users.User#setDateOfBirth(java.lang.String)}.
	 */
	@Test
	public void testSetDateOfBirth() {
		user.setDateOfBirth("July 31 1980");
		String expected = "July 31, 1980"; 
		assertEquals("Date of birth should be: ", expected, user.dateOfBirth()); 
	}

}
