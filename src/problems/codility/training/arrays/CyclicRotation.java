package problems.codility.training.arrays;

public class CyclicRotation {
	
	public int[] solution(int[] A, int K) {

		if ( A.length == K || A.length == 0 ) return A;
		if ( K > A.length ) K = K % A.length;
		
		int[] B = new int[A.length];
		
		for ( int oldIdx = 0 ; oldIdx < A.length ; oldIdx++ ) {
			int newIdx = oldIdx + K;
			if ( newIdx >= A.length ) {
				newIdx = newIdx - A.length;
			}
			B[newIdx] = A[oldIdx];
		}
		return B;
		
    }
	
	public static void main(String[] args) {
		CyclicRotation cr = new CyclicRotation();
		int[] A = {3,8,9,7,6};
		int K = 3;
		cr.solution(A, K);
	}
	public static void printArray(int[] A) {
		System.out.print("[");
		for ( int i : A ) {
			System.out.print(i + ",");
		}
		System.out.print("]");
		System.out.println();
	}
}
