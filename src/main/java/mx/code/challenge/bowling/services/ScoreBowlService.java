package mx.code.challenge.bowling.services;

import java.util.List;

import mx.code.challenge.bowling.domain.BowlDomain;

public interface ScoreBowlService {

	public List<BowlDomain> scoreService(List<BowlDomain> bowlList);
	
	
	public String printScores(List<BowlDomain> bowlList);
}
