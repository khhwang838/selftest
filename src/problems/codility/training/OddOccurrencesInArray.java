package problems.codility.training;

/**
 * 배열안에 pair를 이루지 못하는 (홀수번만 출현하는) 숫자 찾아서 리턴하기
 * 
 * XOR를 사용하여 문제 해결
 * (XOR는 스왑할 때도 사용이 가능)
 * 
 * A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.
 * 
 * For example, in array A such that:
 * 
 *   A[0] = 9  A[1] = 3  A[2] = 9
 *   A[3] = 3  A[4] = 9  A[5] = 7
 *   A[6] = 9
 * the elements at indexes 0 and 2 have value 9,
 * the elements at indexes 1 and 3 have value 3,
 * the elements at indexes 4 and 6 have value 9,
 * the element at index 5 has value 7 and is unpaired.
 * Write a function:
 * 
 * int solution(int A[], int N);
 * 
 * that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.
 * 
 * For example, given array A such that:
 * 
 *   A[0] = 9  A[1] = 3  A[2] = 9
 *   A[3] = 3  A[4] = 9  A[5] = 7
 *   A[6] = 9
 * the function should return 7, as explained in the example above.
 * 
 * Assume that:
 * 
 * N is an odd integer within the range [1..1,000,000];
 * each element of array A is an integer within the range [1..1,000,000,000];
 * all but one of the values in A occur an even number of times.
 * Complexity:
 * 
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
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
