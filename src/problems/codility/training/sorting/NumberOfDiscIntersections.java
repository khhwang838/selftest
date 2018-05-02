package problems.codility.training.sorting;

/**
 * 
 * @author Kihyun
 * @created   2018-05-01
 */
public class NumberOfDiscIntersections {
	public int solution(int[] A) {
        int intersectCnt = 0;
        
        
        for ( int index = 1 ; index < A.length ; index++ ) {
        	if ( intersectCnt > 10000000 ) return -1;
        	// TODO : 교차 지점 개수 구하기
        	
        }
        return intersectCnt;
    }
	public int intersects(int a, int aRadius, int b, int bRadius) {
		
		if ( a < b ) {
			if ( a - aRadius > b - bRadius ) {
				return 2;
			} else if ( a - aRadius == b - bRadius ) {
				
			} else {
				// a - aRadius < b - bRadius
			}
		}
		
		
		
		return 0;
	}
}
