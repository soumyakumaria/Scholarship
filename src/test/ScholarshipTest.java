/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import scholarship.Scholarship;

/**
 * This class contains the test cases for the Scholarship class.
 * @author Tiffany 
 *
 */
public class ScholarshipTest {
	
	private final Scholarship s = new Scholarship(); 
	/**
	 * Test method for {@link scholarship.Scholarship#getName()}.
	 */
	@Test
	public void testGetName() {
		s.setName("Wictchcraft and Wizardry Award");
		assertNotNull("Name should not be empty.", s.getName());
	}

	/**
	 * Test method for {@link scholarship.Scholarship#setName(java.lang.String)}.
	 */
	@Test
	public void testSetName() {
		s.setName("Wictchcraft and Wizardry Award");
		String expected = "Wictchcraft and Wizardry Award"; 
		assertEquals("Name should be: ", expected, s.getName()); 
	}

	/**
	 * Test method for {@link scholarship.Scholarship#getMinGPA()}.
	 */
	@Test
	public void testGetMinGPA() {
		s.setMinGPA("3.9");
		assertNotNull("Minimum GPA should not be empty.", s.getMinGPA());
	}

	/**
	 * Test method for {@link scholarship.Scholarship#setMinGPA(java.lang.String)}.
	 */
	@Test
	public void testSetMinGPA() {
		s.setMinGPA("3.9");
		String expected = "3.9"; 
		assertEquals("Minimum GPA should be: ", expected, s.getMinGPA()); 
	}

	/**
	 * Test method for {@link scholarship.Scholarship#getAntirequisite()}.
	 */
	@Test
	public void testGetAntirequisite() {
		s.setName("......");
		assertNotNull("Name should not be empty.", s.getName());
	}

	/**
	 * Test method for {@link scholarship.Scholarship#setAntirequisite(java.lang.String)}.
	 */
	@Test
	public void testSetAntirequisite() {
		s.setAntirequisite("......");
		String expected = "......"; 
		assertEquals("Antirequisite should be: ", expected, s.getAntirequisite()); 
	}

	/**
	 * Test method for {@link scholarship.Scholarship#getNumAvailable()}.
	 */
	@Test
	public void testGetNumAvailable() {
		s.setNumAvailable(1);
		assertNotNull("Number available should not be empty.", s.getNumAvailable());
	}

	/**
	 * Test method for {@link scholarship.Scholarship#setNumAvailable(int)}.
	 */
	@Test
	public void testSetNumAvailable() {
		s.setNumAvailable(1);
		int expected = 1; 
		assertEquals("Number available should be: ", expected, s.getNumAvailable()); 
	}

	/**
	 * Test method for {@link scholarship.Scholarship#getNominations()}.
	 */
	@Test
	public void testGetNominations() {
		String[] nominations = {"Albus Dumbledore:", "Harry Potter"}; 
		s.setNominations(nominations);
		assertNotNull("Nomination should not be empty.", s.getNominations());
	}

	/**
	 * Test method for {@link scholarship.Scholarship#setNominations(java.lang.String[])}.
	 */
	@Test
	public void testSetNominations() {
		String[] nominations = {"Albus Dumbledore:", "Harry Potter"}; 
		s.setNominations(nominations);
		String [] expected = nominations; 
		assertEquals("Nominations should be: ", expected, s.getNominations()); 
	}

	/**
	 * Test method for {@link scholarship.Scholarship#isGrant()}.
	 */
	@Test
	public void testIsGrant() {
		s.setGrant(false);
		assertFalse("Grant should be: ", s.isGrant());
	}

	/**
	 * Test method for {@link scholarship.Scholarship#setGrant(boolean)}.
	 */
	@Test
	public void testSetGrant() {
		s.setGrant(true);
		boolean expected = true; 
		assertEquals("Is grant should be: ", expected, s.isGrant()); 
	}

	/**
	 * Test method for {@link scholarship.Scholarship#getDescription()}.
	 */
	@Test
	public void testGetDescription() {
		s.setDescription("Awarded to those that show excellence in Ilvermorny School of Witchcraft and Wizardry");
		assertNotNull("Description should not be empty.", s.getDescription());
	}

	/**
	 * Test method for {@link scholarship.Scholarship#setDescription(java.lang.String)}.
	 */
	@Test
	public void testSetDescription() {
		s.setDescription("Awarded to those that show excellence in Ilvermorny School of Witchcraft and Wizardry");
		String expected = "Awarded to those that show excellence in Ilvermorny School of Witchcraft and Wizardry"; 
		assertEquals("Description should be: ", expected, s.getDescription()); 
	}

	/**
	 * Test method for {@link scholarship.Scholarship#getMoney()}.
	 */
	@Test
	public void testGetMoney() {
		s.setMoney(5000); 
		assertNotNull("Money should not be empty.", s.getMoney());
	}

	/**
	 * Test method for {@link scholarship.Scholarship#setMoney(double)}.
	 */
	@Test
	public void testSetMoney() {
		s.setMoney(5000);
		double expected = 5000; 
		assertEquals("Money should be: ", expected, s.getMoney()); 
	}

	/**
	 * Test method for {@link scholarship.Scholarship#getFrequency()}.
	 */
	@Test
	public void testGetFrequency() {
		s.setFrequency("Once a school year"); 
		assertNotNull("Frequency should not be empty.", s.getFrequency());
	}

	/**
	 * Test method for {@link scholarship.Scholarship#setFrequency(java.lang.String)}.
	 */
	@Test
	public void testSetFrequency() {
		s.setFrequency("Once a school year");
		String expected = "Once a school year"; 
		assertEquals("Frequency should be: ", expected, s.getFrequency()); 
	}

	/**
	 * Test method for {@link scholarship.Scholarship#getDuration()}.
	 */
	@Test
	public void testGetDuration() {
		s.setDuration("For a full school year.");
		assertNotNull("Duration should not be empty.", s.getDuration());
	}

	/**
	 * Test method for {@link scholarship.Scholarship#setDuration(java.lang.String)}.
	 */
	@Test
	public void testSetDuration() {
		s.setDuration("For a full school year.");
		String expected = "For a full school year"; 
		assertEquals("Duration should be: ", expected, s.getDuration()); 
	}
}
