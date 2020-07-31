package mx.code.challenge.bowling;

import java.util.List;
import java.util.Scanner;

import mx.code.challenge.bowling.domain.BowlDomain;
import mx.code.challenge.bowling.services.PrintScoreService;
import mx.code.challenge.bowling.services.ReadFileService;
import mx.code.challenge.bowling.services.ScoreBowlService;
import mx.code.challenge.bowling.services.impl.PrintScoreServiceImpl;
import mx.code.challenge.bowling.services.impl.ReadFileServiceImpl;
import mx.code.challenge.bowling.services.impl.ScoreBowlServiceImpl;

public class App 
{
	
	private static final Scanner scanner = new Scanner(System.in);
	
    public static void main( String[] args )
    {
        ReadFileService readFile = new ReadFileServiceImpl();
        ScoreBowlService scoreBowl = new ScoreBowlServiceImpl();
        PrintScoreService printScore = new PrintScoreServiceImpl();
        if(args.length == 1) {
        	List<BowlDomain> bowlList = readFile.readFileBowling(args[0]);
        	bowlList = scoreBowl.scoreService(bowlList);
        	String result = printScore.printScores(bowlList);
        	System.out.println(result);
        }else {
        	System.out.println("Write the name of file you want scoring like java -jar CodeChallengeBowling-0.0.1-SNAPSHOT.jar path/to/file.txt");
        }
        
        
    }
}
