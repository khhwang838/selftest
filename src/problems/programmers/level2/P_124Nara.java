/**
 * Created on Mar 30, 2019 by Keichee
 */
package problems.programmers.level2;

public class P_124Nara {

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			System.out.println(solution(i));
		}
	}

	public static String solution(int n) {
		String answer = "";
		int[] arr = { 4, 1, 2 };
		int remainder;
		while (n > 0) {
			remainder = n % 3;
			n = n / 3;
			
			System.out.println("몫: " + n + ", 나머지: " + remainder + ", arr[나머지]: " + arr[remainder]);
			
			if (remainder == 0) {
				n -= 1;
			}
			answer = arr[remainder] + answer;
		}
		return answer;
	}
}
