package mavenpractice;

import static org.junit.Assert.*;

import org.junit.Test;

public class ElectionTest {

	@Test
	public void createElectionWithNullCandidates() {
		assertThrows(IllegalArgumentException.class, () -> {
			
		});
	}

}
