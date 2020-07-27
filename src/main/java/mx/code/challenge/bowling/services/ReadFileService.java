package mx.code.challenge.bowling.services;

import java.util.List;
import mx.code.challenge.bowling.domain.BowlDomain;

public interface ReadFileService {
	
	public List<BowlDomain> readFileBowling(String url);
		
	
	public BowlDomain convertToBowlDomain(String[] bowlRecordAux, int idBowl);

}
