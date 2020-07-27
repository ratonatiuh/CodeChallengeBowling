package mx.code.challenge.bowling.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import mx.code.challenge.bowling.domain.BowlDomain;
import mx.code.challenge.bowling.services.ScoreBowlService;

public class ScoreBowlServiceImpl implements ScoreBowlService {

	public List<BowlDomain> scoreService(List<BowlDomain> bowlList) {
		List<String> names = bowlList.stream()
				.map(BowlDomain::getName)
				.distinct()
				.collect(Collectors.toList());
		List<BowlDomain> result = new ArrayList();
		int i = 0;
		while(i<names.size()) {
			String nameGamer = names.get(i);
			List<BowlDomain> gamer = bowlList.stream()
					.filter(x -> x.getName().equals(nameGamer))
					.collect(Collectors.toList());
			int j = 0;
			int frame = 1;
			int score = 0;
			while(j<gamer.size()) {
				gamer.get(i).setFrame(frame);
				if(gamer.get(j).getPinfalls() < 10 && frame <=10 &&  j+1<gamer.size()) {
					int turnPinFalls = gamer.get(j).getPinfalls() + gamer.get(j+1).getPinfalls();
					if(turnPinFalls < 10 && j+1<gamer.size() && frame <=10) {
						//System.out.println("Ya aqui queda el score.");
						score = score
								+ turnPinFalls;
						gamer.get(j).setScore(score);
						gamer.get(j).setFrame(frame);
						if(gamer.get(j).getHit() == 2)
							gamer.get(j).setHit(2);
						else
							gamer.get(j).setHit(0);
						gamer.get(j+1).setScore(score);
						gamer.get(j+1).setFrame(frame);
						if(gamer.get(j+1).getHit() == 2)
							gamer.get(j+1).setHit(2);
						else
							gamer.get(j+1).setHit(1);
						result.add(gamer.get(j));
						result.add(gamer.get(j+1));
						j++;
						if(frame==10) {
							gamer.get(j+2).setScore(score);
							gamer.get(j+2).setFrame(frame);
							gamer.get(j+2).setHit(3);
							result.add(gamer.get(j+2));
							
						}
					}else if( j+1<gamer.size()  && frame <=10){
						//System.out.println("Es spair");
						int bowl1 = gamer.get(j+2).getPinfalls();
						score = score
								+ turnPinFalls
								+ bowl1;
						gamer.get(j).setScore(score);
						gamer.get(j).setFrame(frame);
						gamer.get(j).setHit(0);
						gamer.get(j+1).setScore(score);
						gamer.get(j+1).setFrame(frame);
						gamer.get(j+1).setHit(1);
						result.add(gamer.get(j));
						result.add(gamer.get(j+1));
						j++;
						if(frame==10) {
							gamer.get(j+2).setScore(score);
							gamer.get(j+2).setFrame(frame);
							gamer.get(j+2).setHit(3);
							result.add(gamer.get(j+2));
							
						}
					}
				}else if( j+2<gamer.size() && frame <=10) {
					//System.out.println("Es chuza:");
					int bowl1 = gamer.get(j+1).getPinfalls();
					int bowl2 = gamer.get(j+2).getPinfalls();
					score = score 
							+ gamer.get(j).getPinfalls() 
							+ bowl1 
							+ bowl2;
					gamer.get(j).setScore(score);
					gamer.get(j).setFrame(frame);
					gamer.get(j).setHit(0);
					result.add(gamer.get(j));
					if(frame==10) {
						gamer.get(j+1).setScore(score);
						gamer.get(j+1).setFrame(frame);
						gamer.get(j+1).setHit(3);
						result.add(gamer.get(j+1));
						gamer.get(j+2).setScore(score);
						gamer.get(j+2).setFrame(frame);
						gamer.get(j+2).setHit(3);
						result.add(gamer.get(j+2));
						
					}
				}else if(frame>10) {
					break;
				}
				/*
				System.out.println("game from: " + gamer.get(j).getName() 
						+ " frame: " + gamer.get(j).getFrame()
						+ " pinfalls: " + gamer.get(j).getPinfalls() 
						+  " " + gamer.get(j+1).getPinfalls()
						+  " " + gamer.get(j+2).getPinfalls()
 						+ " hit: " + gamer.get(j).getHit()
						+ " score: " + gamer.get(j).getScore());
						*/	
						
				frame++;
				j++;
			}
			i++;
		}
		
		return result;
	}


	@Override
	public String printScores(List<BowlDomain> bowlList) {
		// TODO Auto-generated method stub
		String result = "";
		List<String> names = bowlList.stream()
				.map(BowlDomain::getName)
				.distinct()
				.collect(Collectors.toList());
		int i = 0;
		result += "Frame \t \t";
		int j = 1;
		while(j<=10) {
			result += j + " \t \t";
			j++;
		}
		while(i<names.size()) {
			String nameGamer = names.get(i);
			List<BowlDomain> gamer = bowlList.stream()
					.filter(x -> x.getName().equals(nameGamer))
					.collect(Collectors.toList());
			j = 0;
			result += "\n";
			result+=nameGamer+"\n";
			
			j=0;
			
			result += "Pinfalls \t";
			while(j<gamer.size()) {
				if(gamer.get(j).getPinfalls() == 10) {
					result += "\t X \t";
				}else if((j+1) < gamer.size() &&
						(gamer.get(j).getPinfalls()+
						gamer.get(j+1).getPinfalls()) ==10){
					result += gamer.get(j).getPinfalls() + "\t /  \t";
					j++;
				}else {
					if(gamer.get(j).getHit() == 2)
						result += "F \t" + gamer.get(j+1).getPinfalls() + " \t";
					else if((j+1) < gamer.size() && gamer.get(j+1).getHit() == 2)
						result += gamer.get(j).getPinfalls() + " \t F \t";
					else if((j+1) < gamer.size())
						result += gamer.get(j).getPinfalls() + " \t" + gamer.get(j+1).getPinfalls() + " \t";
					j++;
				}
				j++;
			}
			j=0;
			result += "\n";
			result += "Score \t \t";
			while(j<gamer.size()) {
				result += gamer.get(j).getScore() + " \t \t";
				if(gamer.get(j).getPinfalls() == 10) {
					j++;
				}else {
					j += 2;
				}
			}
			
			i++;
		}
		return result;
	}
}
