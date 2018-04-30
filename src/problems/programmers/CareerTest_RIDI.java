package problems.programmers;

import java.util.Arrays;

/**
 * My Solutions for Ridi Algorithm Test
 * 
 * 알고리즘1 : 괄호가 제대로 닫혀있는지 검사하는 알고리즘. (괄호는 소괄호만 사용)
 * 알고리즘2 : 숫자스트링을 입력받아 만들 수 있는 최대길이의 팰린드롬(palindrome, 앞뒤로 읽어도 동일한 값이 나오는 것) 길이 구하기
 * 알고리즘3 : 가로등 사이의 거리가 균일하다고 가정했을 때, 가로등으로 도로 전체를 밝히기 위한 최소 가로등 사이의 거리 구하기
 * 
 * @author Kihyun
 * @created   2018-04-25
 */
public class CareerTest_RIDI {

	// 알고리즘 1
	boolean solution1(String s) {

		if (s.length() % 2 > 0)
			return false;
		if (s.startsWith(")"))
			return false;
		if (s.endsWith("("))
			return false;

		int numOfOpenParenthesis = 0;

		for (int idx = 0; idx < s.length(); idx++) {

			if (s.charAt(idx) == '(') {
				numOfOpenParenthesis++;
			} else {
				if (numOfOpenParenthesis == 0) {
					return false;
				} else {
					numOfOpenParenthesis--;
				}
			}
		}
		return numOfOpenParenthesis == 0 ? true : false;
	}

	// 알고리즘 2
	public static int solution2(String N) {
		int answer = 0;
		int[] cnt = new int[10];
		// 각 숫자별 개수 구하기
		for (int i = 0; i < N.length(); i++) {
			cnt[N.charAt(i) - 48] += 1;
		}
		boolean onlyZeros = true;
		boolean hasOdds = false;
		// 숫자별 개수를 이용하여 만들 수 있는 팰린드롬 길이 구하기
		for (int idx = 0 ; idx < cnt.length ; idx++ ) {
			int cntPerNum = cnt[idx];
			if ( idx > 0 && cnt[idx] > 1) {
				onlyZeros = false;
			}
			if (cntPerNum % 2 == 1) {
				hasOdds = true;
			}
			answer += cntPerNum / 2 * 2;	// 홀수개가 존재할 경우 1을 뺀 만큼의 길이만 계산
		}
		if ( onlyZeros ) {
			return 1;
		} else if (hasOdds) {
			// 홀수개의 숫자가 하나 이상 존재할 경우 길이에 1을 추가
			return answer + 1;
		} else {
			return answer;
		}
	}

	// 알고리즘 3
	public static int solution3(int l, int[] v) {
		int answer = 0;

		Arrays.sort(v);
		int first = v[0];   // 첫번째 가로등과 길의 시작점 사이의 거리
        int last = l - v[v.length-1];  // 마지막 가로등과 길의 종점까지의 거리
        int maxDbetweenLights = 0;  // 가로등 사이의 거리 최대값
		for (int index = 0; index + 1 < v.length; index++) {
			int d = v[index + 1] - v[index];
			if (maxDbetweenLights < d) {
				maxDbetweenLights = d;
			}
		}
		int maxD = Math.max((maxDbetweenLights + 1) / 2, Math.max(first, last));
		answer = maxD;
		return answer;
	}

	public static void main(String[] args) {
		 System.out.println(solution2("100011"));
	}

}
