package services;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Solutions")
public class Solution {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LevelNum")
	private int LevelNum;
	@Column(name = "Solution")
	private String Solution;

	public Solution(int LevelNum, String Solution) {
		setLevelNum(LevelNum);
		setSolution(Solution);
	}
	
	public Solution() {}

	
	public int getLevelNum() {
		return LevelNum;
	}
	public void setLevelNum(int levelNum) {
		LevelNum = levelNum;
	}
	public String getSolution() {
		return Solution;
	}
	public void setSolution(String solution) {
		Solution = solution;
	}

	@Override
	public String toString() {
		return "lvlnum: " +LevelNum + " sol: " + Solution;
	}

}