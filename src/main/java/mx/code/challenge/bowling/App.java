package mx.code.challenge.bowling;

import java.util.List;

import mx.code.challenge.bowling.domain.BowlDomain;
import mx.code.challenge.bowling.services.ReadFileService;
import mx.code.challenge.bowling.services.ScoreBowlService;
import mx.code.challenge.bowling.services.impl.ReadFileServiceImpl;
import mx.code.challenge.bowling.services.impl.ScoreBowlServiceImpl;

public class App 
{
    public static void main( String[] args )
    {
        ReadFileService readFile = new ReadFileServiceImpl();
        ScoreBowlService scoreBowl = new ScoreBowlServiceImpl();
        List<BowlDomain> bowlList = readFile.readFileBowling("BowlRecord/bowlRecord_04.txt");
        bowlList = scoreBowl.scoreService(bowlList);
        String result = scoreBowl.printScores(bowlList);
        System.out.println(result);
        
        
    }
}
