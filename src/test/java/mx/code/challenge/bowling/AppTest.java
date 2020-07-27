package mx.code.challenge.bowling;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import mx.code.challenge.bowling.domain.BowlDomain;
import mx.code.challenge.bowling.services.ReadFileService;
import mx.code.challenge.bowling.services.ScoreBowlService;
import mx.code.challenge.bowling.services.impl.ReadFileServiceImpl;
import mx.code.challenge.bowling.services.impl.ScoreBowlServiceImpl;


public class AppTest {


    @Test
    public void testAppCase01()
    {
    	ReadFileService readFile = new ReadFileServiceImpl();
        ScoreBowlService scoreBowl = new ScoreBowlServiceImpl();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        List<BowlDomain> bowlTest = readFile.readFileBowling("BowlRecord/bowlRecord_01.txt");
        
        System.out.println("1. Testing case 01 example of the pdf with the Jeff and John players.");
        
        
        bowlTest = scoreBowl.scoreService(bowlTest);
        
        String result =  "Frame 	 	1 	 	2 	 	3 	 	4 	 	5 	 	6 	 	7 	 	8 	 	9 	 	10 	 	\n";
        
        result += "Jeff\n";
        result += "Pinfalls 		 X 	7	 /  	9 	0 		 X 	0 	8 	8	 /  	F 	6 		 X 		 X 		 X 	8 	1 	\n";
        result += "Score 	 	20 	 	39 	 	48 	 	66 	 	74 	 	84 	 	90 	 	120 	 	148 	 	167 	 	167 	 	\n";
        result +=  "John\n";
        result +=  "Pinfalls 	3	 /  	6 	3 		 X 	8 	1 		 X 		 X 	9 	0 	7	 /  	4 	4 		 X 	9 	0 	\n";
        result +=  "Score 	 	16 	 	25 	 	44 	 	53 	 	82 	 	101 	 	110 	 	124 	 	132 	 	151 	 	151 	 	";
    	
        assertEquals(result,  scoreBowl.printScores(bowlTest));
        System.out.println(scoreBowl.printScores(bowlTest));
        
    }
    
    @Test
    public void testAppCase02()
    {
    	ReadFileService readFile = new ReadFileServiceImpl();
        ScoreBowlService scoreBowl = new ScoreBowlServiceImpl();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        List<BowlDomain> bowlTest = readFile.readFileBowling("BowlRecord/bowlRecord_02.txt");
        
        System.out.println("2. Testing case 02 example with perfect game. All strikes.");
        
        bowlTest = scoreBowl.scoreService(bowlTest);
        
        String result =  "Frame 	 	1 	 	2 	 	3 	 	4 	 	5 	 	6 	 	7 	 	8 	 	9 	 	10 	 	\n";
        result += "Carl\n";
        result += "Pinfalls 		 X 		 X 		 X 		 X 		 X 		 X 		 X 		 X 		 X 		 X 		 X 		 X 	\n";
        result += "Score 	 	30 	 	60 	 	90 	 	120 	 	150 	 	180 	 	210 	 	240 	 	270 	 	300 	 	300 	 	300 	 	";
        assertEquals(result,  scoreBowl.printScores(bowlTest));
        System.out.println(scoreBowl.printScores(bowlTest));
    }
    
    @Test
    public void testAppCase03()
    {
    	ReadFileService readFile = new ReadFileServiceImpl();
        ScoreBowlService scoreBowl = new ScoreBowlServiceImpl();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        List<BowlDomain> bowlTest = readFile.readFileBowling("BowlRecord/bowlRecord_03.txt");
        
        System.out.println("3. Testing case 03 example with perfect game and all fault game.");
        
        bowlTest = scoreBowl.scoreService(bowlTest);
        
        String result =  "Frame 	 	1 	 	2 	 	3 	 	4 	 	5 	 	6 	 	7 	 	8 	 	9 	 	10 	 	\n";
        result += "Carl\n";
        result += "Pinfalls 		 X 		 X 		 X 		 X 		 X 		 X 		 X 		 X 		 X 		 X 		 X 		 X 	\n";
        result += "Score 	 	30 	 	60 	 	90 	 	120 	 	150 	 	180 	 	210 	 	240 	 	270 	 	300 	 	300 	 	300 	 	\n";
        result += "Chanchis\n";
        result += "Pinfalls 	F 	0 	F 	0 	F 	0 	F 	0 	F 	0 	F 	0 	F 	0 	F 	0 	F 	0 	F 	0 	\n";
        result += "Score 	 	0 	 	0 	 	0 	 	0 	 	0 	 	0 	 	0 	 	0 	 	0 	 	0 	 	0 	 	";
        
        assertEquals(result,  scoreBowl.printScores(bowlTest));
        System.out.println(scoreBowl.printScores(bowlTest));
        
    }
}
