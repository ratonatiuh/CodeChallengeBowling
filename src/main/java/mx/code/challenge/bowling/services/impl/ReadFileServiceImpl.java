package mx.code.challenge.bowling.services.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import mx.code.challenge.bowling.domain.BowlDomain;
import mx.code.challenge.bowling.services.ReadFileService;

public class ReadFileServiceImpl implements ReadFileService{
	/*
	 * The readFileBowling function have a url of a file and return a List of BowlDomain
	 * params: String
	 * return: List<BowlDomain>
	 */
	public List<BowlDomain> readFileBowling(String url){
		List<BowlDomain> listBowling = new ArrayList<BowlDomain>();
		try {
			//obtain the line of a file to obtain name score.
			List<String> strFile = Files.lines(Paths.get(url))
			.map(element -> (String) element)
			.collect(Collectors.toList());
			int i=0;
			// convert recort to BowlDomain.
			while(i < strFile.size()) {
				String[] bowlRecordAux = strFile.get(i).split(" ");
				BowlDomain bowlLine = convertToBowlDomain(bowlRecordAux);
				listBowling.add(bowlLine);
				i++;
			}
		} catch (IOException ex) {
			ex.getMessage();
		}
		return listBowling;
	}
	
	/*
	 * The convertToBowlDomain function obtain the name, pinfalls and frame to put
	 * params: String[], int
	 * return: BowlDomain
	 */
	public BowlDomain convertToBowlDomain(String[] bowlRecordAux) {
		BowlDomain bowlLine = new BowlDomain();
		bowlLine.setName(bowlRecordAux[0]);
		int pinfalls = 0;
		// when is fault use the Fault value of domain as true
		if(!bowlRecordAux[1].equals("F")){
			pinfalls = Integer.parseInt(bowlRecordAux[1]);
			bowlLine.setHit(0);
			bowlLine.setFault(false);
		}else
			bowlLine.setFault(true);;
		bowlLine.setPinfalls(pinfalls);
		return bowlLine;
	}

}
