/**
 * Created on Dec 15, 2018 by Keichee
 */
package problems.baekjoon;

import java.util.Scanner;

public class P_2775 {

	/*
	 * - 일반화한 공식
		a층 b호의 사람 수 = (a층 b-1호) + (a-1층 b호)
		
		0층 b호 = b 명
		a층 1호 = 1 명
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int testcases = Integer.parseInt(scan.nextLine());
		// 층수
		int[] floor = new int[testcases];
		// 호수 
		int[] line = new int[testcases];
		
		for (int i = 0 ; i < testcases ; i++) {
			floor[i] = Integer.parseInt(scan.nextLine());
			line[i] = Integer.parseInt(scan.nextLine());
		}
		
		for (int i = 0 ; i < testcases ; i++) {
			// a층 b호의 사람 수 = (a층 b-1호) + (a-1층 b호)
			int result = numOfPeople(floor[i], line[i]);
			System.out.println(result);
		}
	}
	
	public static int numOfPeople(int a, int b) {
		if( a == 0 ) {
			return b;
		} else if ( b == 1 ) {
			return 1;
		} else {
			// ex. a = 2, b = 2
			int under = numOfPeople(a-1, b);	// 1, 2
			int left = numOfPeople(a, b-1);// 2, 1
			return left + under;
		}
	}
}
