package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import exception.*;
import model.*;
import service.*;

@RestController
@RequestMapping
public class BowlingController {

	@Autowired
	private GameService gameService;
	
	public static final String GET_SCORE = "/game/{roll}";

	@RequestMapping(value = GET_SCORE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Score>> retrieveScoreForSinglePlayerRoll(@PathVariable("roll") String roll)
			throws InvalidInputException, SystemException {
		System.out.println("\n\n\n\n  Incontroller--------\n\n\n");
		try {
			List<String> rollStringList = new ArrayList<String>();
			rollStringList.add(roll);
			List<Score> scoreList = gameService.evaluate(rollStringList);
			return new ResponseEntity<>(scoreList, HttpStatus.OK);
		} catch (InvalidInputException e) {
			throw new SystemException("The input provided is not valid", e);
		} catch (SystemException e) {
			throw new SystemException(
					"There is an application issue due to which Application was not able to calculate score", e);
		} catch (Exception e) {
			throw new SystemException("Exception while running the game", e);
		}
	}

}
