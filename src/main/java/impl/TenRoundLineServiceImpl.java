package impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.*;
import model.Roll;
import service.*;
import utility.RollCreator;

@Service
public class TenRoundLineServiceImpl implements LineService {

	@Autowired
	RoundService roundService;
	
	public Integer calculateLineScore(String rollString) throws SystemException {
		try {
			List<Character> rollsCharList = rollString.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

			int totalRollCount = rollsCharList.size();
			rollsCharList.add(null);
			rollsCharList.add(null);
			int totalScore = CalculateTotalScoreByRecreatingRoundInLoops(rollsCharList, totalRollCount);
			return totalScore;
		} catch (Exception e) {
			throw new SystemException("Exception while Calculating Line Score for a single Line with Single Roll", e);
		}
	}

	private int CalculateTotalScoreByRecreatingRoundInLoops(List<Character> rollsCharList,
			int totalRollCount) throws SystemException {
		try {
			int totalScore = 0;
			int rollPos = 0;
			int rollBonus = 0;
			do {
				Roll firstRoll = RollCreator.createRoll(rollsCharList.get(rollPos));
				Roll secondRoll = RollCreator.createRoll(rollsCharList.get(rollPos + 1));
				Roll thirdRoll = RollCreator.createRoll(rollsCharList.get(rollPos + 2));
				totalScore += roundService.getScore(firstRoll, secondRoll, thirdRoll);
				rollPos += roundService.getConsumed(firstRoll, secondRoll);
				rollBonus = roundService.getBonus(firstRoll, secondRoll);
			} while (totalRollCount - rollBonus > ++rollPos);
			return totalScore;
		} catch (Exception e) {
			throw new SystemException("Exception while Calculating Score while recreating the rounds", e);
		}
	}
}
