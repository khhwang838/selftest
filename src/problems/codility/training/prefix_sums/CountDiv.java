package problems.codility.training.prefix_sums;

/**
 * @author Kihyun
 * @created   2018-04-30
 */
public class CountDiv {
	
	/*
	 * Key Point : 0 mod K = 0  
	 */
	public static int solution(int A, int B, int K) {
		
		if ( A == B ) {
			if ( A % K == 0 ) return 1;
			return 0;
		} 
		// important two lines-----------------
		int result = B/K - Math.max(0, A-1)/K;	
		if ( A == 0 ) result+=1;
		//-------------------------------------
		return result;
	}
	public static void main(String[] args) {
		
		System.out.println(solution(0, 14, 2));
	}
}
