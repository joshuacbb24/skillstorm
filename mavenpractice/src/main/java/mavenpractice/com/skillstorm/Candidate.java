package mavenpractice.com.skillstorm;

public class Candidate {

	private String name;
	private String politicalAffiliation;
	private int numVotes;
	
	public Candidate() {
		
	}

	public Candidate(String name, String politicalAffiliation) {
		super();
		this.name = name;
		this.politicalAffiliation = politicalAffiliation;
	}

	public Candidate(String name, String politicalAffiliation, int numVotes) {
		super();
		if (numVotes < 0) {
			throw new IllegalArgumentException("Cannot have negative votes");
		}
		this.name = name;
		this.politicalAffiliation = politicalAffiliation;
		this.numVotes = numVotes;
	}

	public String getName() {
		return name;
	}

	public String getPoliticalAffiliation() {
		return politicalAffiliation;
	}

	public int getNumVotes() {
		return numVotes;
	}
	
	public void addVote() {
		// Prevent integer overflow
		if (numVotes != Integer.MAX_VALUE) {
			numVotes++;
		}
		
	}
}
