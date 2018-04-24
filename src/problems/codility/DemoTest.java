package problems.codility;

import java.util.Arrays;

public class DemoTest {

	public static void main(String[] args) {
		
		System.out.println(test());
	}
	
	public static int test() {
		int[] A = new int[] {1, 4, 3, 6, 2, 1};
		A = new int[] {1,2,3};
		Arrays.sort(A);
		int maxA = 0;
		for ( int idx = 0, s = 1; idx < A.length ;idx++,s++ ) {
			System.out.println(A[idx] + " : " + s);
			if ( A[idx] > s ) {
				return s;
			}else if ( s > A[idx] ) s--;
			
			if ( maxA < A[idx] ) maxA = A[idx];
		}
		if ( maxA > 0 ) {
		    return maxA + 1;
		}
		return 1;
	}
}
