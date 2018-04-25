package problems.hackerrank;

import java.util.Scanner;

/**
 * Problem : Sam and sub-strings
 * 
 * Sample Input 0
 * 16
 * Sample Output 0
 * 23
 * Explanation 0
 * The substring of number 16 are 16, 1 and 6. Whose sum is 23.
 * 
 * Sample Input 1
 * 123
 * Sample Output 1
 * 164
 * Explanation 1
 * The sub-strings of 123 are 1, 2, 3, 12, 23, 123 which sums to 164.
 * 
 * @author Kihyun
 * @created   2018-04-12
 */
public class SamSubstrings {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        String balls = in.next();
//		String balls = "960880276897";	// 335573181
		int result = substrings(balls);
		System.out.println(result);
	}
	
	public static int substrings(String balls) {
		// TODO : 일부 테스트 케이스만 통과....일부는 wrong answer 또는 runtime error....T.T
		// ball의 substring 조합을 찾아서 합 구하기
		if ( balls.length() == 1 ) {
			return Integer.parseInt(balls);
		} else {
			long sum = 0;
			for ( int len = 1; len <= balls.length(); len++) {
				for ( int idx = 0 ; idx < balls.length() - (len -1) ; idx++ ) {
					long subNum = Long.parseLong(balls.substring(idx, idx+len));
					sum += subNum;
				}
			}
			return (int)(sum % (Math.pow(10, 9) + 7));
		}
	} 
}