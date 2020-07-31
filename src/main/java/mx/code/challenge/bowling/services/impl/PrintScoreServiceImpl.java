package mx.code.challenge.bowling.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import mx.code.challenge.bowling.domain.BowlDomain;
import mx.code.challenge.bowling.services.PrintScoreService;
import mx.code.challenge.bowling.services.ScoreBowlService;

public class PrintScoreServiceImpl implements PrintScoreService {

	/*
	 * The printScores function obtain the scorefile as a list of BowlDomain,
	 * and return a String to print the value as order like a score bowl
	 * params: List<BowlDomain>
	 * return: String
	 */
	@Override
	public String printScores(List<BowlDomain> bowlList) {
		// TODO Auto-generated method stub
		String result = "";
		// List the name of the players
		ScoreBowlService scoreService = new ScoreBowlServiceImpl();
		List<String> names =  scoreService.obtainNamePlayers(bowlList);
		int i = 0;
		// To print the first line as frames 1 to 10
		result += "Frame \t \t";
		int j = 1;
		while(j<=10) {
			result += j + " \t \t";
			j++;
		}
		while(i<names.size()) {
			String namePlayer = names.get(i);
			// To print the name Player i
			List<BowlDomain> player = bowlList.stream()
					.filter(x -> x.getName().equals(namePlayer))
					.collect(Collectors.toList());
			j = 0;
			result += "\n";
			result+=namePlayer+"\n";
			
			//To print the pinfalls
			j=0;
			result += "Pinfalls \t";
			while(j<player.size()) {
				// Print an X when strike.
				if(player.get(j).getPinfalls() == 10) {
					// for last Strike print near for the 10 frame if have 3 balls in other case print on second tab
					if(player.get(j).getFrame() != 10 ) {
						result += "\t X \t";
					}else {
						result +="X \t";
					}
				}else if((j+1) < player.size() &&
						(player.get(j).getPinfalls()+
								player.get(j+1).getPinfalls()) ==10){
					// Print an / when the sum of j and j+1 are 10 and print in the second value
					result += player.get(j).getPinfalls() + "\t /  \t";
					if(player.get(j).getFrame() == 10 && (j+2) < player.size()) {
						if(player.get(j+2).getPinfalls() == 10) {
							result += "";
						}else {
							result += player.get(j+2).getPinfalls();
						}
					}
					j++;
				}else {
					// Print an F when the turn is fault.
					if(player.get(j).isFault()) {
						result += "F \t"; 
						if((j+1) < player.size() && player.get(j+1).isFault()) {
									result += "F \t";
						}else if((j+1) < player.size()){
							result += player.get(j+1).getPinfalls() + "\t";
						}
					}else if(player.get(j).isFault() && (j+1)<player.size() && player.get(j+1).isFault()) {
						result += "F \t F \t";
					}else if(!player.get(j).isFault() && (j+1)<player.size() && player.get(j+1).isFault()) {
						result += player.get(j).getPinfalls() + "\t F \t"; 
					}else if((j+1)<player.size()){
						result += player.get(j).getPinfalls() + " \t" + player.get(j+1).getPinfalls() + " \t";
					}
					j++;
				}
				j++;
			}
			
			// To print the scores.
			j=0;
			result += "\n";
			result += "Score \t \t";
			while(j<player.size()) {
				result += player.get(j).getScore() + " \t \t";
				if(player.get(j).getPinfalls() == 10) {
					j++;
				}else {
					j += 2;
				}
				if(player.get(j).getFrame() == 10) {
					result += player.get(j).getScore();
					break;
				}
			}
			
			i++;
		}
		return result;
	}

}
