package problems.codility.training.prefix_sums;

/**
 * @author Kihyun
 * @created   2018-05-01
 */
public class MinAvgTwoSlice {

	// TODO : 이해 필요
	public int solution(int[] A) {
        int startPos = 0;
        float minAvg = 10001;
        
        for ( int index = 0 ; index < A.length ; index++ ) {
        	if ( index + 1 < A.length ) {
        		// 2개 짜리
        		float avg = (A[index] + A[index+1]) / 2f;
        		if ( minAvg > avg ) {
        			minAvg = avg;
        			startPos = index;
        		}
        	}
        	if ( index + 2 < A.length ) {
        		float avg = (A[index] + A[index+1] + A[index+2]) / 3f;
        		if ( minAvg > avg ) {
        			minAvg = avg;
        			startPos = index;
        		}
        	}
        }
        return startPos;
    }
}
