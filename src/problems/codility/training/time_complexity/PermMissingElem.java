package problems.codility.training.time_complexity;

/**
 * N개의 distinct한 숫자를 갖는 배열 A를 input으로 받아 missing 숫자를 리턴하기.
 * 배열A에는 1 ~ (N+1) 까지의 숫자가 들어있을 수 있음
 * 
 * An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.
 * 
 * Your goal is to find that missing element.
 * 
 * Write a function:
 * 
 * int solution(int A[], int N);
 * 
 * that, given an array A, returns the value of the missing element.
 * 
 * For example, given array A such that:
 * 
 *   A[0] = 2
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 5
 * the function should return 4, as it is the missing element.
 * 
 * Assume that:
 * 
 * N is an integer within the range [0..100,000];
 * the elements of A are all distinct;
 * each element of array A is an integer within the range [1..(N + 1)].
 * Complexity:
 * 
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
 * 
 * @author Kihyun
 * @created   2018-04-28
 */
public class PermMissingElem {

	/*
	 * 1부터 N+1까지의 합을 구한 뒤 배열의 숫자를 차례로 빼서 마지막에 남는 수가 결과임
	 */
	public static int solution(int[] A) {
        // write your code in Java SE 8
		long N = A.length +1;
        long totalSum = (N*(N+1))/2;
        
        for(int i=0; i<A.length; i++){
            totalSum -= A[i];
        }
        
        return (int)totalSum;
    }
	
	public static void main(String[] args) {
		int[] A = {};
		System.out.println(solution(A));
	}
}
