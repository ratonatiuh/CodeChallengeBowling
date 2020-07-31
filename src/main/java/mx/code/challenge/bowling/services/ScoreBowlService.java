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
	 * The fillBowlRecord function fill the values of a BowlDomain,
	 * and return the BowlDomain with the values needed.
	 * params: BowlDomain
	 * return: BowlDomain
	 */
	public BowlDomain fillBowlRecord(BowlDomain bowlD, int frame, int score, int hit);
	
	/*
	 * The obtainNamePlayers function obtain the names of the players with a
	 * stream and lambda function.
	 * params: List<String>
	 * return: List<BowlDomain>
	 */
	public List<String> obtainNamePlayers(List<BowlDomain> bowlList);
}
