package impl;

import org.springframework.stereotype.Service;

import exception.*;
import model.*;
import service.RoundService;

@Service
public class TwoRollRoundServiceImpl implements RoundService {

	@Override
	public Integer getBonus(Roll firstRoll, Roll secondRoll) throws SystemException {
		try {
			if (firstRoll.isStrike()) {
				return 2;
			} else if (null != secondRoll && secondRoll.isSpare()) {
				return 1;
			} else if (firstRoll.isHit()) {
				return 0;
			} else {
				return 0;
			}
		} catch (Exception e) {
			throw new SystemException("Exception while Calculating Bonus", e);
		}
	}

	@Override
	public Integer getConsumed(Roll firstRoll, Roll secondRoll) throws SystemException {
		try {
			if (firstRoll.isStrike()) {
				return 0;
			} else if (null != secondRoll && secondRoll.isSpare()) {
				return 1;
			} else if (firstRoll.isHit()) {
				return 1;
			} else {
				return 1;
			}
		} catch (Exception e) {
			throw new SystemException("Exception while Calculating Consumed Rolls", e);
		}
	}

	@Override
	public Integer getScore(Roll firstRoll, Roll secondRoll, Roll thirdRoll) throws SystemException {
		try {
			Integer score = 0;
			if (firstRoll.isStrike()) {
				score = firstRoll.getScore() + secondRoll.getScore() + thirdRoll.getScore();
				return score;
			} else if (null != secondRoll && secondRoll.isSpare()) {
				score = secondRoll.getScore() + thirdRoll.getScore();
				return score;
			} else if (firstRoll.isHit()) {
				score = firstRoll.getScore() + secondRoll.getScore();
				return score;
			} else {
				return score;
			}
		} catch (Exception e) {
			throw new SystemException("Exception while Calculating Score", e);
		}
	}
}
