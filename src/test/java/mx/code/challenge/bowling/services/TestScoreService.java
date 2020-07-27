package mx.code.challenge.bowling.services;

import java.util.List;

import org.junit.Test;

import mx.code.challenge.bowling.domain.BowlDomain;
import mx.code.challenge.bowling.services.impl.ReadFileServiceImpl;
import mx.code.challenge.bowling.services.impl.ScoreBowlServiceImpl;

public class TestScoreService {
	
	@Test
	public void testScoreService() {
		ReadFileService readFile = new ReadFileServiceImpl();
        ScoreBowlService scoreBowl = new ScoreBowlServiceImpl();
        List<BowlDomain> bowlList = readFile.readFileBowling("BowlRecord/bowlRecord_02.txt");
        
        bowlList = scoreBowl.scoreService(bowlList);

	}

}
