package mavenpractice;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import mavenpractice.com.skillstorm.Candidate;

public class CandidateTest {

	@Test // JUnit will run any function in the class annotated with @Test
	@Ignore // This test will now be ignored 
	public void test() {
		// If there are ANY failed tests, the build will not pass the test phase
		fail("Not yet implemented");
	}
	
	@Test
	public void createNormalCandidate() {
		
	}
	
	@Test
	public void createCandidateWithNegativeVotes() {
		// Ensure that I cannot do this
//		try {
//			Candidate c = new Candidate("John", "Cheese", -1);
//		} catch (IllegalArgumentException e) {
//			// TODO: handle exception
//		}		
		assertThrows(IllegalArgumentException.class, () -> {
			Candidate c = new Candidate("John", "Cheese", -1);
			// This block of code should throw an illegal Argument exception
		});
	}
	
	@Test
	public void preventVoteCountOverflow() {
		Candidate c = new Candidate("John", "Cheese", Integer.MAX_VALUE);
		c.addVote();
		assertEquals(c.getNumVotes(), Integer.MAX_VALUE); // Passes if equal
	}

}
