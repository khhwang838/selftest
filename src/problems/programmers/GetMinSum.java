package problems.programmers;

import java.util.Arrays;

/**
 * 두 배열의 인자 곱의 합 중 최소값 구하기
 * 
 * a배열의 임의 값과 b배열의 임의값을 곱한값의 sum이 최소인 값 구하기
 *   
 * @author Kihyun
 * @created   2018-04-25
 */
public class GetMinSum {

	public int getMinSum(int[] A, int[] B) {
		int answer = 0;
		Arrays.sort(A);
		Arrays.sort(B);
		for (int i = 0; i < A.length; i++) {
			answer += A[i] * B[B.length - 1 - i];
		}
		return answer;
	}

	public static void main(String[] args) {
		GetMinSum test = new GetMinSum();
		int[] A = { 1, 2 };
		int[] B = { 3, 4 };
		System.out.println(test.getMinSum(A, B));
	}
}
