package utility;

import model.*;

public class RollCreator {
	
	private final static char MISS = '-';
	private final static char SPARE = '/';
	private final static char STRIKE = 'X';
	
	public static Roll createRoll(Character rollChar) {
		Roll roll = null;
		if(rollChar == null || MISS == rollChar) {
			roll = new Miss(0);
		} else if(SPARE == rollChar) {
			roll = new Spare(10);
		} else if(STRIKE == rollChar) {
			roll = new Strike(10);
		} else {
			roll = new Hit(Character.getNumericValue(rollChar));
		}
		return roll;
	}

}
