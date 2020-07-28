/**
 * 
 */
package mx.code.challenge.bowling.services;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import mx.code.challenge.bowling.domain.BowlDomain;
import mx.code.challenge.bowling.services.impl.ReadFileServiceImpl;

/**
 * @author parallels
 *
 */
public class TestReadFileService {
	
	@Test
	public void testReadFile() {
		ReadFileService readFile = new ReadFileServiceImpl();
		List<BowlDomain> bowlTest = readFile.readFileBowling("BowlRecord/bowlRecord_02.txt");
		// 1. checking the size of the file
		System.out.println("1. checking the size of the file bowlRecord_02.txt");
		assertEquals(bowlTest.size(), 12);
		System.out.println("2. checking the divide of element of list obtaining the names");
		for(int i = 0;i<bowlTest.size();i++) {
			assertEquals(bowlTest.get(i).getName(),"Carl");
		}
	}
	
	@Test
	public void testConvertBowlingDomain() {
		ReadFileService readFile = new ReadFileServiceImpl();
		BowlDomain bowlTest = readFile.convertToBowlDomain(new String[]{"Carl","10"});
		System.out.println("1. Checking convert line of file to a BowlDomain.");
		
		BowlDomain bowlExpectative = new BowlDomain();
		bowlExpectative.setName("Carl");
		bowlExpectative.setPinfalls(10);
		System.out.println("2. Checking name in bowlDomain " + bowlExpectative.getName());
		
		assertEquals(bowlTest.getFrame(), bowlExpectative.getFrame());
		System.out.println("3. Checking Frame in bowlDomain " + bowlExpectative.getPinfalls());
		
		assertEquals(bowlTest.getPinfalls(), bowlExpectative.getPinfalls());
		
	}

}
