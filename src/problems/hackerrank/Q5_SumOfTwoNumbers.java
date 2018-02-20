package problems.hackerrank;

import java.util.HashSet;
import java.util.Set;

public class Q5_SumOfTwoNumbers {

	static int numberOfPairs(int[] a, long k) {
		Set<Long> b = new HashSet<>();
		int cnt = 0;
		int cnt2 = 0;
		for (int i = 0; i < a.length; i++) {
			boolean notExist = b.add((long)a[i]);
			if ( !notExist && a[i]*2 == k ) {
				cnt2++;
			}
		}
		for ( Long key : b ) {
			System.out.println("key: " + key);
			if ( (k-key != key) && b.contains(k-key)) {
				cnt++;
			}
		}
		return cnt/2 + cnt2;
	}
}



