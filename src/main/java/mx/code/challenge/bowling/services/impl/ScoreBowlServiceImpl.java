package mx.code.challenge.bowling.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import mx.code.challenge.bowling.domain.BowlDomain;
import mx.code.challenge.bowling.services.ScoreBowlService;

public class ScoreBowlServiceImpl implements ScoreBowlService {

	/*
	 * The scoreService function obtain the scorefile as a list of BowlDomain, categorize, count score
	 * and put inside a list of BowlDomain as return.
	 * params: List<BowlDomain>
	 * return: List<BowlDomain>
	 */
	public List<BowlDomain> scoreService(List<BowlDomain> bowlList) {
		// obtaining the names of the players with streams, and lambdas
		List<String> names = obtainNamePlayers(bowlList);
		List<BowlDomain> result = new ArrayList();
		int i = 0;
		while(i<names.size()) {
			String namePlayer = names.get(i);
			//obtain the play if each player to made the frame and scores values.
			List<BowlDomain> player = bowlList.stream()
					.filter(x -> x.getName().equals(namePlayer))
					.collect(Collectors.toList());
			int j = 0;
			int frame = 1;
			int score = 0;
			while(j<player.size()) {
				player.get(i).setFrame(frame);
				if(player.get(j).getPinfalls() < 10 && frame <=10 &&  j+1<player.size()) {
					int turnPinFalls = player.get(j).getPinfalls() + player.get(j+1).getPinfalls();
					if(turnPinFalls < 10 && j+1<player.size() && frame <=10) {
						// this is when the two balls are less than 10 and is not the last frame. we need
						// to summarize the score plus the pinfalls of the frame.
						//System.out.println("Ya aqui queda el score.");
						score = score
								+ turnPinFalls;
						player.set(j, fillBowlRecord(player.get(j), frame, score, 0));
						player.set(j+1, fillBowlRecord(player.get(j+1), frame, score, 1));
						result.add(player.get(j));
						result.add(player.get(j+1));
						j++;
					}else if( (j+1)<player.size()  && frame <=10){
						//This part is when the first ball not strike all the pin and in second strike the rest to summarize 10
						//System.out.println("Es spare");
						int bowl1 = player.get(j+2).getPinfalls();
						score = score
								+ turnPinFalls
								+ bowl1;
						player.set(j, fillBowlRecord(player.get(j), frame, score, 0));
						player.set(j+1, fillBowlRecord(player.get(j+1), frame, score, 1));
						result.add(player.get(j));
						result.add(player.get(j+1));
						if(frame==10) {
							// because is a spare the last frame count the 3rd ball
							player.set(j+2, fillBowlRecord(player.get(j+2), frame, score, 2));
							result.add(player.get(j+2));
							
						}
						j++;
					}
				}else if( j+2<player.size() && frame <=10) {
					// this part is for a Strike when 10 pinfalls in the first turn of the frame sumarize the next 2 balls.
					//System.out.println("Es chuza:");
					int bowl1 = player.get(j+1).getPinfalls();
					int bowl2 = player.get(j+2).getPinfalls();
					score = score 
							+ player.get(j).getPinfalls() 
							+ bowl1 
							+ bowl2;
					player.set(j, fillBowlRecord(player.get(j), frame, score, 0));
					result.add(player.get(j));
					if(frame==10) {
						// when strike the last bowl summarize 2 balls at 3 of the 10 frame.
						player.set(j+1, fillBowlRecord(player.get(j+1), frame, score, 1));
						player.set(j+2, fillBowlRecord(player.get(j+2), frame, score, 2));
						result.add(player.get(j+1));
						result.add(player.get(j+2));
					}
					//there is not more frames than 10
				}else if(frame>10) {
					break;
				}
				frame++;
				j++;
			}
			i++;
		}
		return result;
	}


	
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
		List<String> names =  obtainNamePlayers(bowlList);
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
	
	/*
	 * The fillBowlRecord function fill the values of a BowlDomain,
	 * and return the BowlDomain with the values needed.
	 * params: BowlDomain
	 * return: BowlDomain
	 */
	public BowlDomain fillBowlRecord(BowlDomain bowlD, int frame, int score, int hit) {
		bowlD.setFrame(frame);
		bowlD.setScore(score);
		bowlD.setHit(hit);
		return bowlD;
	}



	/*
	 * The obtainNamePlayers function obtain the names of the players with a
	 * stream and lambda function.
	 * params: List<String>
	 * return: List<BowlDomain>
	 */
	@Override
	public List<String> obtainNamePlayers(List<BowlDomain> bowlList) {
		return bowlList.stream()
				.map(BowlDomain::getName)
				.distinct()
				.collect(Collectors.toList());
	}
	
	
}
