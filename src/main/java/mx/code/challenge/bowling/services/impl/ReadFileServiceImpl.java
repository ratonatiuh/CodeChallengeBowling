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
	public List<BowlDomain> readFileBowling(String url){
		List<BowlDomain> listBowling = new ArrayList<BowlDomain>();
		try {
			List<String> strFile = Files.lines(Paths.get(url))
			.map(element -> (String) element)
			.collect(Collectors.toList());
			int i=0;
			while(i < strFile.size()) {
				String[] bowlRecordAux = strFile.get(i).split(" ");
				BowlDomain bowlLine = convertToBowlDomain(bowlRecordAux, i);
				listBowling.add(bowlLine);
				i++;
			}
		} catch (IOException ex) {
			ex.getMessage();
		}
		return listBowling;
	}
	
	public BowlDomain convertToBowlDomain(String[] bowlRecordAux, int frame) {
		BowlDomain bowlLine = new BowlDomain();
		bowlLine.setFrame(frame);
		bowlLine.setName(bowlRecordAux[0]);
		int pinfalls = 0;
		if(!bowlRecordAux[1].equals("F")){
			pinfalls = Integer.parseInt(bowlRecordAux[1]);
			bowlLine.setHit(0);
		}else
			bowlLine.setHit(2);
		bowlLine.setPinfalls(pinfalls);
		return bowlLine;
	}

}
