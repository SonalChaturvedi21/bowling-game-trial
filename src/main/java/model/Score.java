package model;

import java.util.ArrayList;
import java.util.List;

public class Score {
	
	private List<Integer> scoreList=new ArrayList<Integer>();
	private String message;
	private boolean isSuccess;
	private Error error;
	public List<Integer> getScoreList() {
		return scoreList;
	}
	public void setScoreList(List<Integer> scoreList) {
		this.scoreList = scoreList;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public Error getError() {
		return error;
	}
	public void setError(Error error) {
		this.error = error;
	}
	@Override
	public String toString() {
		return "Score [scoreList=" + scoreList + ", message=" + message + ", isSuccess=" + isSuccess + ", error="
				+ error + "]";
	}

}
