/**
 * Created on Mar 30, 2019 by Keichee
 */
package problems.programmers.level2;

import java.util.Arrays;

public class Towers {

	public static void main(String[] args) {
		int[] heights = {6,9,5,7,4};
		System.out.println(Arrays.toString(solution(heights)));
	}
	public static int[] solution(int[] heights) {
		int[] answer = new int[heights.length];
		for (int i = heights.length - 1; i >= 0;i--) {
			if (i == 0) {
				answer[0] = 0;
			} else {
				for (int j = i - 1; j >= 0; j--) {
					if (heights[j] > heights[i]) {
						answer[i] = (j + 1);
						break;
					}
				}
			}
		}
		return answer;
	}
}
