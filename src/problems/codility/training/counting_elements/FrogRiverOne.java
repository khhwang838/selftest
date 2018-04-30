package problems.codility.training.counting_elements;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A small frog wants to get to the other side of a river. The frog is initially located on one bank of the river (position 0) and wants to get to the opposite bank (position X+1). Leaves fall from a tree onto the surface of the river.
 * 
 * You are given an array A consisting of N integers representing the falling leaves. A[K] represents the position where one leaf falls at time K, measured in seconds.
 * 
 * The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves appear at every position across the river from 1 to X (that is, we want to find the earliest moment when all the positions from 1 to X are covered by leaves). You may assume that the speed of the current in the river is negligibly small, i.e. the leaves do not change their positions once they fall in the river.
 * 
 * For example, you are given integer X = 5 and array A such that:
 * 
 *   A[0] = 1
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 4
 *   A[4] = 2
 *   A[5] = 3
 *   A[6] = 5
 *   A[7] = 4
 * In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.
 * 
 * Write a function:
 * 
 * int solution(int X, int A[], int N);
 * 
 * that, given a non-empty array A consisting of N integers and integer X, returns the earliest time when the frog can jump to the other side of the river.
 * 
 * If the frog is never able to jump to the other side of the river, the function should return −1.
 * 
 * For example, given X = 5 and array A such that:
 * 
 *   A[0] = 1
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 4
 *   A[4] = 2
 *   A[5] = 3
 *   A[6] = 5
 *   A[7] = 4
 * the function should return 6, as explained above.
 * 
 * Assume that:
 * 
 * N and X are integers within the range [1..100,000];
 * each element of array A is an integer within the range [1..X].
 * Complexity:
 * 
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(X), beyond input storage (not counting the storage required for input arguments).
 * 
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
