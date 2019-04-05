/**
 * Created on Feb 16, 2019 by Keichee
 */
package problems.programmers;

public class NumberOfPAndY {

	boolean solution(String s) {
		boolean answer = true;

		int p = 0, y = 0;
		
		for (char c : s.toLowerCase().toCharArray()) {
			if (c == 'p') {
				p++;
			} else if (c == 'y') {
				y++;
			}
		}
		if (p != y)
			return false;

		return answer;
	}
}
