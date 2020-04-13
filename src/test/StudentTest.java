/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import scholarship.Scholarship;
import users.Student;
import users.User;

/**
 * This class contains the test cases for the Student class. 
 * @author Tiffany 
 *
 */
public class StudentTest {
	private final Student st = new Student(); 
	private final User user = new User(); 
	private final Scholarship s = new Scholarship(); 
	
	/**
	 * Test method for {@link users.Student#addPending(scholarship.Scholarship)}.
	 */
	@Test
	public void testAddPending() {
		Scholarship[] pending = new Scholarship[0];
		pending = user.addScholarship(pending, s);
		String[] expected = null; 
		assertEquals("Array is intialized and is empty.", expected, st.getPending()); 
	}

	/**
	 * Test method for {@link users.Student#addAwaiting(scholarship.Scholarship)}.
	 */
	@Test
	public void testAddAwaiting() {
		Scholarship[] awaiting = new Scholarship[0];
		awaiting = user.addScholarship(awaiting, s);
		String[] expected = null; 
		assertEquals("Array is intialized and is empty.", expected, st.getAwaiting()); 
	}

	/**
	 * Test method for {@link users.Student#addAccepted(scholarship.Scholarship)}.
	 */
	@Test
	public void testAddAccepted() {
		Scholarship[] accepted = new Scholarship[0];
		accepted = user.addScholarship(accepted, s);
		String[] expected = null; 
		assertEquals("Array is intialized and is empty.", expected, st.getAccepted()); 
	}

	/**
	 * Test method for {@link users.Student#getPending()}.
	 */
	@Test
	public void testGetPending() {
		Scholarship[] pending = new Scholarship[0];
		pending = user.addScholarship(pending, s);
		assertNull("Array initialized and should be: ", st.getPending()); 
	}

	/**
	 * Test method for {@link users.Student#getAwaiting()}.
	 */
	@Test
	public void testGetAwaiting() {
		Scholarship[] awaiting = new Scholarship[0];
		awaiting = user.addScholarship(awaiting, s);
		assertNull("Array initialized and should be: ", st.getAwaiting());
	}

	/**
	 * Test method for {@link users.Student#getAccepted()}.
	 */
	@Test
	public void testGetAccepted() {
		Scholarship[] accepted = new Scholarship[0];
		accepted = user.addScholarship(accepted, s);
		assertNull("Array initialized and should be: ", st.getAccepted());
	}

	/**
	 * Test method for {@link users.Student#setPending(scholarship.Scholarship[])}.
	 */
	@Test
	public void testSetPending() {
		Scholarship pending = new Scholarship();
		pending = null; 
		assertEquals("Pending is initialized and should be: ", pending, st.getPending());
	}

	/**
	 * Test method for {@link users.Student#setAwaiting(scholarship.Scholarship[])}.
	 */
	@Test
	public void testSetAwaiting() {
		Scholarship awaiting = new Scholarship();
		awaiting = null; 
		assertEquals("Pending is initialized and should be: ", awaiting, st.getAwaiting());
	}

	/**
	 * Test method for {@link users.Student#setAccepted(scholarship.Scholarship[])}.
	 */
	@Test
	public void testSetAccepted() {
		Scholarship accepted = new Scholarship();
		accepted = null; 
		assertEquals("Pending is initialized and should be: ", accepted, st.getAccepted());
	}

	/**
	 * Test method for {@link users.Student#getGrades()}.
	 */
	@Test
	public void testGetGrades() {
		st.setGrades("F");
		assertNotNull("Grades should not be empty.", st.getGrades()); 
	}

	/**
	 * Test method for {@link users.Student#setGrades(java.lang.String)}.
	 */
	@Test
	public void testSetGrades() {
		st.setGrades("F");
		String expected = "F"; 
		assertEquals("Grades should be: ", expected, st.getGrades()); 
	}
}
