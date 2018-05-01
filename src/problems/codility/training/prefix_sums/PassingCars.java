package problems.codility.training.prefix_sums;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kihyun
 * @created   2018-05-01
 */
public class PassingCars {
	
	public int solution(int[] directionOfCars) {
		
		
		List<Integer> eastCarIndices = new ArrayList<Integer>();
		for ( int index = 0 ; index < directionOfCars.length ; index++ ) {
			int direction = directionOfCars[index];
			if ( direction == 0 ) eastCarIndices.add(index);
		}
		int passingCars = 0;
		
		for ( int index = 0 ; index < eastCarIndices.size() ; index++ ) {
			if (passingCars > 1000000000) return -1;
			passingCars += directionOfCars.length - (eastCarIndices.get(index) + 1) // max passing cars
					- ( eastCarIndices.size() - ( index + 1 ) );	// # of 0's from index in eastCarIndices  
		}
		return passingCars;
    }
}
