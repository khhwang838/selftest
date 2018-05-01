package problems.codility.training.counting_elements;

import java.util.Arrays;

/**
 * @author Kihyun
 * @created   2018-04-30
 */
public class PermCheck {
	public int solution(int[] A) {
		if ( A.length == 1 && A[0] == 1 ) return 1;
		Arrays.sort(A);
		if ( A[0] != 1 ) return 0;
		for ( int i = 0 ; i < A.length - 1; i++ ) {
			if ( A[i] + 1 != A[i+1] ) return 0;
		}
		return 1;
	}
}
