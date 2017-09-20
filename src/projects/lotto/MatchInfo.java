package projects.lotto;

import java.util.ArrayList;
import java.util.List;

public class MatchInfo {

	private int maxMatchCnt;
	private final List<Integer> matchCnt = new ArrayList<Integer>();
	private final List<Integer> matchThNum = new ArrayList<Integer>(); // 유사한 당첨 숫자의 회차 번호 
	private final List<int[]> matchNumList = new ArrayList<int[]>();	// 유사한 당첨 숫자의 실제 번호 
	
	public void setMaxMatchCnt(int maxMatchCnt) {
		this.maxMatchCnt = maxMatchCnt;
	}
	public int getMaxMatchCnt() {
		return maxMatchCnt;
	}
	public List<Integer> getMatchCnt() {
		return matchCnt;
	}
	public List<Integer> getMatchThNum() {
		return matchThNum;
	}
	public List<int[]> getMatchNumList() {
		return matchNumList;
	}
}
