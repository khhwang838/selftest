package problems.codility.training.arrays;

/**
 * 배열안에 pair를 이루지 못하는 (홀수번만 출현하는) 숫자 찾아서 리턴하기
 * 
 * XOR를 사용하여 문제 해결
 * (XOR는 스왑할 때도 사용이 가능)
 * 
 * @author Kihyun
 * @created   2018-04-27
 */
public class OddOccurrencesInArray {

	public static int solution(int[] A) {
		int num = 0;
		for ( int i = 0 ; i < A.length ; i++ ) {
			num = num ^ A[i];
		}
		return num;
	}
	public static void main(String[] args) {
		int[] A = {9, 3, 9};
		System.out.println(solution(A));
		
		
	}
	
	/*
	 * XOR를 사용한 스왑 알고리즘
	 */
	public void swap() {
		int A = 5;
		int B = 23;

		A = A ^ B;
		B = A ^ B;
		A = A ^ B;
	}
	/*
	 * 일반적인 스왑 알고리즘
	 */
	public void swap_0() {
		int A = 5;
		int B = 23;
		int temp;

		temp = A;
		A = B;
		B = temp;
	}
}
