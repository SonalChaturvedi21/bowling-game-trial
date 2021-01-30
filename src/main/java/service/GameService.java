package service;

import java.util.List;

import model.Score;

public interface GameService {
	
	List<Score> evaluate(List<String> rollStringList);

}
