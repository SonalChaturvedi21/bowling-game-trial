package service;

import model.Roll;

public interface RoundBonusService {
	
	Integer getBonus(Roll firstRoll, Roll secondRoll);

}
