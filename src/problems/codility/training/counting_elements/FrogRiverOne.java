package problems.codility.training.counting_elements;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Kihyun
 * @created   2018-04-30
 */
public class FrogRiverOne {
	
	/*
	 * Success
	 */
	public static int solution(int X, int[] A) {
		
		Map<Integer, Integer> positionTimeMap = new HashMap<>();
		
		for ( int time = 0; time < A.length ; time++ ) {
			if ( positionTimeMap.get(A[time]) == null ) {
				positionTimeMap.put(A[time], time);
			}
		}
		// 모든 위치에 나뭇잎이 떨어졌는지 검사
		Set<Integer> positionSet = positionTimeMap.keySet();
		if ( positionSet.size() < X ) return -1;
		// 가장 늦게 떨어진 나뭇잎의 시간 반환
		Collection<Integer> timeList = positionTimeMap.values();
		int maxTime = 0;
		for ( int time : timeList ) {
			if ( maxTime < time ) maxTime = time;
		}
		return maxTime;
    }
	public static void main(String[] args) {
		
		System.out.println("result: " + solution(5, new int[] {1, 3, 1, 4, 2, 3, 5, 4}));
	}
	/*
	 * FAIL : Detected time complexity: O(N ** 2)
	 */
	public static int solution1(int X, int[] A) {
		
		List<Integer> aList = new ArrayList<>(A.length);
		for ( int a : A ) {
			aList.add(a);
		}
		int maxIndex = Integer.MIN_VALUE;
		for ( int t = 1 ; t < X + 1 ; t++ ) {
			int firstIndex = aList.indexOf(t);
			if ( firstIndex < 0 ) return -1;
			if ( maxIndex < firstIndex ) maxIndex = firstIndex;
		}
		return maxIndex;
    }
}
