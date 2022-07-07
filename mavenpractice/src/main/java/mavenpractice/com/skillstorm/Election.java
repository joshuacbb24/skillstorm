package mavenpractice.com.skillstorm;

import java.util.LinkedList;

public class Election {

	private LinkedList<Candidate> candidates;
	private LinkedList<Ballot> ballots;
	private LinkedList<Ballot> flaggedBallots = new LinkedList<>();
	private LinkedList<Candidate> winners;
	
	
	
	public Election(LinkedList<Candidate> candidates, LinkedList<Ballot> ballots) {
		super();
		this.candidates = candidates;
		this.ballots = ballots;
	}



	public Election(LinkedList<Candidate> candidates, LinkedList<Ballot> ballots, LinkedList<Ballot> flaggedBallots,
			LinkedList<Candidate> winners) {
		super();
		this.candidates = candidates;
		this.ballots = ballots;
		this.flaggedBallots = flaggedBallots;
		this.winners = winners;
	}
	
	
}
