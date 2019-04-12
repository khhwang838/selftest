/**
 * Created on Apr 12, 2019 by Keichee
 */
package problems.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

public class BirthdayChocolate {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(1);
		Assert.assertEquals(1, birthday(list, 4, 1));
		list.clear();
		
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		Assert.assertEquals(0, birthday(list, 3, 2));
	}
	
	static int birthday(List<Integer> s, int d, int m) {
		int answer = 0;
		int sum;
		for(int index = 0; index <= s.size() - m; index++) {
			sum = 0;
			for(int j = index; j < index + m; j++) {
				sum += s.get(j);
			}
			if(sum == d) {
				answer++;
			}
		}
		return answer;
    }
}
