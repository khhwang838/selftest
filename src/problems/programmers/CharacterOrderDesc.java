/**
 * Created on Feb 23, 2019 by Keichee
 */
package problems.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CharacterOrderDesc {

	public static void main(String[] args) {
		System.out.println(solution("Zbcdefg"));
		System.out.println(solution2("Zbcdefg"));
	}

	public static String solution(String s) {
		char[] arr = s.toCharArray();
		Arrays.sort(arr);
		char[] result = new char[s.length()];
		for(int i= arr.length-1; i >= 0; i--) {
			result[i] = arr[arr.length -1 - i];
		}
		String answer = String.valueOf(result);
		return answer;
	}
	
	public static String solution2(String s) {
		List<String> list = new ArrayList<>();
		list.addAll(Arrays.asList(s.split("")));
		Collections.sort(list);
		Collections.reverse(list);
		StringBuilder sb = new StringBuilder();
		for(String charStr : list) {
			sb.append(charStr);
		}
		String answer = sb.toString();
		return answer;
	}
}
