/**
 * Created on Feb 23, 2019 by Keichee
 */
package problems.programmers;

public class MiddleNumbers {

	public static void main(String[] args) {
		System.out.println(solution("abcd"));
		System.out.println(solution("abc"));
		System.out.println(solution("abcdef"));
		System.out.println(solution("abcdefg"));
	}

	public static String solution(String s) {
		String answer = "";
		if (s.length() % 2 == 0) {
			int index = s.length() / 2 - 1;
			answer = s.substring(index, index + 2);
		} else {
			answer = String.valueOf(s.charAt(s.length() / 2));
		}
		return answer;
	}
}
