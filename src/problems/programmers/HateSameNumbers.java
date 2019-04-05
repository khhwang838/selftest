/**
 * Created on Feb 23, 2019 by Keichee
 */
package problems.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HateSameNumbers {

	public static void main(String[] args) {
		int[] arr = new int[3];
		arr[0] = 1;
		arr[0] = 2;
		arr[0] = 3;
		System.out.println(Arrays.toString(arr));
	}
	public int[] solution(int []arr) {
		if(arr.length == 1) {
			return arr;
		}
		List<Integer> result = new ArrayList<>();
		int currentNumber = arr[0];
		result.add(currentNumber);
		for(int idx=1; idx<arr.length;idx++) {
			if(currentNumber == arr[idx]) {
				continue;
			}
			currentNumber = arr[idx];
			result.add(currentNumber);
		}
		
		int[] answer = new int[result.size()];
		int idx = 0;
		for(Integer i : result) {
			answer[idx++] = i;
		}
        return answer;
	}
	
}
