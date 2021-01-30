package impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.*;
import model.Score;
import service.*;

@Service
public class SinglePlayerGameServiceImpl implements GameService {
	
	@Autowired
	LineService lineService;

	public List<Score> evaluate(List<String> rollStringList)
			throws SystemException, InvalidInputException {
		try {
			List<Score> gameScoreList = new ArrayList<Score>();
			if (rollStringList == null || rollStringList.isEmpty()) {
				getGameScoreForInvalidInput(gameScoreList);
				throw new InvalidInputException(
						"No Input for Score was provided. Hence not able to calculate score for game.",
						new IllegalArgumentException());
			} else {
				getGameScoreForValidInput(rollStringList, gameScoreList);
				return gameScoreList;
			}
		} catch (Exception e) {
			throw new SystemException("Exception while evaluating the Single Player game", e);
		}

	}
	
	private void getGameScoreForInvalidInput(List<Score> gameScoreList) {
		Score score = new Score();
		score.setMessage("No Input for Score was provided. Hence not able to calculate score for game.");
		score.setSuccess(false);
		gameScoreList.add(score);
	}
	
	private void getGameScoreForValidInput(List<String> rollStringList,
			List<Score> gameScoreList) throws SystemException {
		try {
			Score score = new Score();
			String rollString = rollStringList.get(0);
			List<Integer> scoreList = new ArrayList<Integer>();
			Integer lineScore = lineService.calculateLineScore(rollString);
			scoreList.add(lineScore);
			score.setScoreList(scoreList);
			score.setMessage(getSuccessMessage(lineScore));
			score.setSuccess(true);
			gameScoreList.add(score);
		} catch (Exception e) {
			throw new SystemException("Exception while Calculating Score for an Input that has been determined valid",
					e);
		}
	}

	private String getSuccessMessage(Integer score) {
		return "Your current score is : "+score;
	}

}
