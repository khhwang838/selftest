/**
 * Created on Apr 7, 2019 by Keichee
 */
package problems.codejam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class QualificationRound_2019 {

	public static void main(String[] args) {
		test();
//		solution();
		
	}
	private static void solution() {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numOfTestCases = in.nextInt();
		
		StringBuilder resultBuilder = new StringBuilder();
		for (int i = 0; i < numOfTestCases; i++) {
			int testCase = in.nextInt();
			resultBuilder.append("Case #")
			.append(i + 1)
			.append(": ");
			
			String dividedNum = String.valueOf(testCase / 2);
			String num1,num2;
			num1 = dividedNum;
			
			if (testCase % 2 == 0) {
				// even number
				num2 = dividedNum;
			} else {
				// odd number
				num2 = String.valueOf((testCase / 2) + 1);
			}
			
			char[] num1Arr = num1.toCharArray();
			char[] num2Arr = num2.toCharArray();
			
			for(int j = 0; j < num1Arr.length; j++) {
				if(num1Arr[j] == '4' && num2Arr[j] == '4') {
					num1Arr[j] = '3';
					num2Arr[j] = '5';
				} else if (num1Arr[j] == '4') {
					if(num1Arr[j] > num2Arr[j]) {
						num1Arr[j] += 1;
						num2Arr[j] -= 1;
					} else {
						num1Arr[j] -= 1;
						num2Arr[j] += 1;
					}
				} else if (num2Arr[j] == '4') {
					if(num1Arr[j] > num2Arr[j]) {
						num1Arr[j] += 1;
						num2Arr[j] -= 1;
					} else {
						num1Arr[j] -= 1;
						num2Arr[j] += 1;
					}
				} else {
					// do nothing
				}
			}
			num1 = String.valueOf(num1Arr);
			num2 = String.valueOf(num2Arr);
			
			resultBuilder
			.append(num1)
			.append(" ")
			.append(num2)
			.append(System.lineSeparator());
			
			System.out.println(resultBuilder.toString());
			resultBuilder.setLength(0);
		}
	}
	
	private static void test() {
		int numOfTestCases = 9999999;
		StringBuilder resultBuilder = new StringBuilder();
		for (int i = 0; i < numOfTestCases; i++) {
			int testCase = i + 2;	// 숫자 임의 세팅
			resultBuilder.append("Case #")
			.append(i + 1)
			.append(": ");
			
			String dividedNum = String.valueOf(testCase / 2);
			String num1,num2;
			num1 = dividedNum;
			
			if (testCase % 2 == 0) {
				// even number
				num2 = dividedNum;
			} else {
				// odd number
				num2 = String.valueOf((testCase / 2) + 1);
			}
			
			char[] num1Arr = num1.toCharArray();
			char[] num2Arr = num2.toCharArray();
			
			for(int j = 0; j < num1Arr.length; j++) {
				if(num1Arr[j] == '4' && num2Arr[j] == '4') {
					num1Arr[j] = '3';
					num2Arr[j] = '5';
				} else if (num1Arr[j] == '4') {
					if(num1Arr[j] > num2Arr[j]) {
						System.out.println("111");
						num1Arr[j] += 1;
						num2Arr[j] -= 1;
					} else {
						System.out.println("222");
						num1Arr[j] -= 1;
						num2Arr[j] += 1;
					}
				} else if (num2Arr[j] == '4') {
					if(num1Arr[j] > num2Arr[j]) {
						// 3 4
						System.out.println("333");
						num1Arr[j] += 1;
						num2Arr[j] -= 1;
					} else {
						System.out.println("444");
						num1Arr[j] -= 1;
						num2Arr[j] += 1;
					}
				} else {
					// do nothing
				}
			}
			num1 = String.valueOf(num1Arr);
			num2 = String.valueOf(num2Arr);
			
			resultBuilder
			.append(num1)
			.append(" ")
			.append(num2)
			.append(System.lineSeparator());
			
			if((Integer.parseInt(num1) + Integer.parseInt(num2) != testCase)
					|| num1.contains("4") || num2.contains("4")) {
				System.out.println(testCase + " : " + num1 + " " + num2);
				break;
			}
//			System.out.println(resultBuilder.toString());
			resultBuilder.setLength(0);
		}
	}
}
