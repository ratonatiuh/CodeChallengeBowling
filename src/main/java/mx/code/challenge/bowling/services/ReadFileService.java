package mx.code.challenge.bowling.services;

import java.util.List;
import mx.code.challenge.bowling.domain.BowlDomain;

public interface ReadFileService {
	
	/*
	 * The readFileBowling function have a url of a file and return a List of BowlDomain
	 * params: String
	 * return: List<BowlDomain>
	 */
	public List<BowlDomain> readFileBowling(String url);
		
	/*
	 * The convertToBowlDomain function obtain the name, pinfalls and frame to put
	 * params: String[], int
	 * return: BowlDomain
	 */
	public BowlDomain convertToBowlDomain(String[] bowlRecordAux);

}
