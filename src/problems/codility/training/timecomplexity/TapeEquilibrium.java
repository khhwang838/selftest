package problems.codility.training.timecomplexity;

/**
 * A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.
 * 
 * Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
 * 
 * The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
 * 
 * In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
 * 
 * For example, consider array A such that:
 * 
 *   A[0] = 3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = 4
 *   A[4] = 3
 * We can split this tape in four places:
 * 
 * P = 1, difference = |3 − 10| = 7 
 * P = 2, difference = |4 − 9| = 5 
 * P = 3, difference = |6 − 7| = 1 
 * P = 4, difference = |10 − 3| = 7 
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.
 * 
 * For example, given:
 * 
 *   A[0] = 3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = 4
 *   A[4] = 3
 * the function should return 1, as explained above.
 * 
 * Assume that:
 * 
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−1,000..1,000].
 * Complexity:
 * 
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 * 
 * @author Kihyun
 * @created   2018-04-30
 */
public class TapeEquilibrium {
	public static int solution(int[] A) {
        // write your code in Java SE 8
		
		int totalSum = 0;
		for ( int a : A ) {
			totalSum += a;
		}
		
		int leftSum = 0;
		
		int minDiff = Integer.MAX_VALUE;
		for ( int idx = 0; idx < A.length - 1 ; idx++ ) {
			leftSum += A[idx];
			int rightSum = totalSum - leftSum;
			System.out.println("rSum: " + rightSum);
			int diff = Math.abs(rightSum - leftSum);
			if ( diff < minDiff ) {
				minDiff = diff;
			}
		}
		System.out.println("minDiff: " + minDiff);
		return minDiff;
    }
	
	public static void main(String[] args) {
//		int[] A = {3, 1, 2, 4, 3};
		int[] A = {5, -6, 2, 100, 34};
		System.out.println("result: " + solution(A));
	}
}