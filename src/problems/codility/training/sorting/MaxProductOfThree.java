package problems.codility.training.sorting;

import java.util.Arrays;

/**
 * 
 * @author Kihyun
 * @created   2018-05-01
 */
public class MaxProductOfThree {
	public static int solution(int[] A) {
		Arrays.sort(A);
		int len = A.length;
		int rightProduct = A[len - 3] * A[len - 2] * A[len - 1];
		int firstPositiveIndex =  0;
		for (int i = 0 ; i < A.length ; i++ ) {
			if ( A[i] > 0 ) {
				firstPositiveIndex = i;
				break;
			}
		}
		
		if ( firstPositiveIndex < 2 ) {
			return rightProduct;
		} else {
			return Math.max(A[0]*A[1]*A[len-1], rightProduct);
		}
	}
	public static void main(String[] args) {
		// test cases
		System.out.println(solution(new int[] {-1000, 0, 1, 1000}));
	}
}
