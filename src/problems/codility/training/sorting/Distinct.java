package problems.codility.training.sorting;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Kihyun
 * @created   2018-05-01
 */
public class Distinct {

	public int solution(int[] A) {
		
		Set<Integer> distinct = new HashSet<Integer>();
		
		for ( int a : A ) {
			distinct.add(a);
		}
		return distinct.size();
    }
}
