package problems.codility.training.sorting;

import java.util.Arrays;

/**
 * 
 * @author Kihyun
 * @created   2018-05-01
 */
public class Triangle {

	public int solution(int[] A) {
        Arrays.sort(A);
        for ( int i = 0 ; i < A.length - 2 ; i++ ) {
        	if ( A[i] < 0 ) continue;
        	if ( (long)A[i] + (long)A[i+1] > A[i+2] ) return 1;	// watch out overflow
        }
        return 0;
    }
}
