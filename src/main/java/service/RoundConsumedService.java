package service;

import model.Roll;

public interface RoundConsumedService {
	
	Integer getConsumed(Roll firstRoll, Roll secondRoll);

}
