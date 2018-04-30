package problems.codility.training.counting_elements;

import java.util.Arrays;

/**
 * This is a demo task.
 * 
 * Write a function:
 * 
 * int solution(int A[], int N);
 * 
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 * 
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * 
 * Given A = [1, 2, 3], the function should return 4.
 * 
 * Given A = [−1, −3], the function should return 1.
 * 
 * Assume that:
 * 
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 * Complexity:
 * 
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 * 
 * @author Kihyun
 * @created   2018-04-30
 */
public class MissingInteger {

	public static int solution(int[] A) {
		Arrays.sort(A);
		int spi = 1;
		for ( int i = 0 ; i < A.length ; i++ ) {
			if ( A[i] == spi ) spi++;
		}
		return spi;
    }
	public static void main(String[] args) {
		System.out.println(new int[] {1, 3, 6, 4, 1, 2});	// 5
		System.out.println(new int[] {1, 2, 3});	// 4
		System.out.println(new int[] {-1, -3});	// 1
		
	}
}
