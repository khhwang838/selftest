/**
 * Created on Apr 6, 2019 by Keichee
 */
package problems.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BiggestNumber {

	// [3, 30, 34, 5, 9, 31, 311]
	
	
	// [9, 5, 34, 311, 31, 30, 3]
	
	
	// [9, 5, 34, 3, 31, 311, 30]
	public static void main(String[] args) {
//		int[] numbers = {3, 30, 34, 5, 9, 31, 311};
//		String[] a = new String[numbers.length];
//		for(int i = 0; i < numbers.length; i++) {
//			a[i] = String.valueOf(numbers[i]);
//		}
		String[] a = {"", "0", "1", "11", "4"};
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}
	
	
	public String solution(int[] numbers) {
		String[] a = new String[numbers.length];
		for(int i = 0; i < numbers.length; i++) {
			a[i] = String.valueOf(numbers[i]);
		}
		Arrays.sort(a);
		
		StringBuilder sb = new StringBuilder();
		for(int i = numbers.length - 1 ; i > -1 ; i--) {
			sb.append(a[i]);
		}
		return sb.toString();
	}
	private List<String> sort(String[] numbers) {
		// 동일한 숫자로 시작하는 숫자들 정렬
		List<String> result = new ArrayList<>(numbers.length);
		
		return result;
	}
}
