package problems.codility.training.counting_elements;

import java.util.Arrays;

/**
 * @author Kihyun
 * @created   2018-04-30
 */
public class MaxCounters {

	public static int[] solution(int N, int[] A) {
		int[] counters = new int[N];
		int curMax = 0;
		int tmpMax = 0;
		
		for ( int a : A ) {
			if ( a > 0 && a <= N ) {
				counters[a-1] = Math.max(curMax, counters[a-1]);	// key point 1
				counters[a-1]++;
				if ( counters[a-1] > tmpMax ) {
					tmpMax = counters[a-1];
				}
			} else if ( a == N + 1 ) {
				curMax = tmpMax;
			}
		}
		for ( int index = 0 ; index < counters.length ; index++ ) {
			counters[index] = Math.max(curMax, counters[index]);	// key point 2
		}
		return counters;
    }
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(5, new int[] { 3, 4, 4, 6, 1, 4, 4 })));
		System.out.println(Arrays.toString(solution(5, new int[] { 3, 4, 4, 6, 1, 4, 4, 6 })));
		System.out.println(Arrays.toString(solution(1, new int[] { 2, 1, 1, 2, 1 })));
	}
}
