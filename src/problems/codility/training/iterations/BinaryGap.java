package problems.codility.training.iterations;

/**
 * @author Kihyun
 * @created   2018-04-24
 */
public class BinaryGap {

	public static void main(String[] args) {
		
		System.out.println(solution(2));
		System.out.println(solution(55));
		System.out.println(solution(254));
		System.out.println(solution(63));
		System.out.println(solution(9));
	}
	public static int solution(int N) {
		String bStrOfN = Integer.toBinaryString(N);
		
		System.out.print(bStrOfN + " : ");
		
		int maxGap = 0;
		int currentGap = 0;
		for (int index = 0; index < bStrOfN.length() ; index++ ) {
			if ( bStrOfN.charAt(index) == 49 ) {
				if ( currentGap > maxGap ) {
					maxGap = currentGap;
				}
				currentGap = 0;
			} else {
				currentGap++;
			}
			
		}
		return maxGap;
	}
}
