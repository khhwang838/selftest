/**
 * Created on Dec 8, 2018 by Keichee
 */
package problems.baekjoon;

import java.util.Scanner;

public class P_2675 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCount = scan.nextInt();
		int[] repeatCount = new int[testCount];
		String[] str = new String[testCount];
		
		int n = 0;
		while (n < testCount) {
			repeatCount[n] = scan.nextInt();
			str[n] = scan.nextLine().trim();
			n++;
		}
		
		for ( int i = 0; i < testCount ; i++){
			int rCount = repeatCount[i];
			String s = str[i];
			char[] chars = s.toCharArray();
			for (char c : chars) {
				for (int j = 0; j < rCount; j++) {
					System.out.print(c); // aaaaabbbbb
				}
			}
			System.out.println();
		}
		
	}
}
