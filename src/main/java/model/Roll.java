package model;

public abstract class Roll {

	protected boolean isMiss;
	protected boolean isSpare;
	protected boolean isStrike;
	protected boolean isHit;
	protected int score;
	public boolean isMiss() {
		return isMiss;
	}
	public boolean isSpare() {
		return isSpare;
	}
	public boolean isStrike() {
		return isStrike;
	}
	public boolean isHit() {
		return isHit;
	}
	public int getScore() {
		return score;
	}
	@Override
	public String toString() {
		return "Roll [isMiss=" + isMiss + ", isSpare=" + isSpare + ", isStrike=" + isStrike + ", isHit=" + isHit
				+ ", score=" + score + "]";
	}
}
