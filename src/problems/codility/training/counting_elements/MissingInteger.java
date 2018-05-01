package problems.codility.training.counting_elements;

import java.util.Arrays;

/**
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
