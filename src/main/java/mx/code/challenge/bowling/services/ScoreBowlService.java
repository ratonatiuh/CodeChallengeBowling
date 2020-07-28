package mx.code.challenge.bowling.services;

import java.util.List;

import mx.code.challenge.bowling.domain.BowlDomain;

public interface ScoreBowlService {

	/*
	 * The scoreService function obtain the scorefile as a list of BowlDomain, categorize, count score
	 * and put inside a list of BowlDomain as return.
	 * params: List<BowlDomain>
	 * return: List<BowlDomain>
	 */
	public List<BowlDomain> scoreService(List<BowlDomain> bowlList);
	
	
	/*
	 * The printScores function obtain the scorefile as a list of BowlDomain,
	 * and return a String to print the value as order like a score bowl
	 * params: List<BowlDomain>
	 * return: String
	 */
	public String printScores(List<BowlDomain> bowlList);
	
	
	/*
	 * The obtainNamePlayers function obtain the names of the players with a
	 * stream and lambda function.
	 * params: List<String>
	 * return: List<BowlDomain>
	 */
	public List<String> obtainNamePlayers(List<BowlDomain> bowlList);
}
