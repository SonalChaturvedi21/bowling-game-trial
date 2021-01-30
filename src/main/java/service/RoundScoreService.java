package service;

import model.Roll;

public interface RoundScoreService {
	
	Integer getScore(Roll firstRoll, Roll secondRoll, Roll thirdRoll);

}
