/**
 * Created on Feb 23, 2019 by Keichee
 */
package problems.programmers;

public class SumOfIntegersBetween {

	public static void main(String[] args) {
		
		System.out.println(solution(-100000, -9999));
	}
	
	public static long solution(int a, int b) {
		if(a==b) return a;
		
		long answer = 0;
		int max, min;
		if (a > b) {
			min = b;
			max = a;
		} else {
			min = a;
			max = b;
		}
		for (int i = min; i <= max; i++) {
			answer += i;
		}
		return answer;
	}
}
