/**
 * Created on Feb 16, 2019 by Keichee
 */
package problems.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DivisorSortNumbers {

	public int[] solution(int[] arr, int divisor) {
		List<Integer> remainZeroNumbers = new ArrayList<>();
		for (int number : arr) {
			if (number % divisor == 0) {
				remainZeroNumbers.add(number);
			}
		}
		if (remainZeroNumbers.size() > 0) {
			Collections.sort(remainZeroNumbers);
			int[] answer = new int[remainZeroNumbers.size()];
			for (int i = 0; i < answer.length; i++) {
				answer[i] = remainZeroNumbers.get(i);
			}
			return answer;
		} else {
			int[] answer = {-1};
			return answer;
		}
	}

}
