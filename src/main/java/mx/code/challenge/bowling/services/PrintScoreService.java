package mx.code.challenge.bowling.services;

import java.util.List;

import mx.code.challenge.bowling.domain.BowlDomain;

public interface PrintScoreService {
	
	/*
	 * The printScores function obtain the scorefile as a list of BowlDomain,
	 * and return a String to print the value as order like a score bowl
	 * params: List<BowlDomain>
	 * return: String
	 */
	public String printScores(List<BowlDomain> bowlList);
	

}
